package com.mini.springlv2library.service;

import com.mini.springlv2library.dto.DtoConverter;
import com.mini.springlv2library.dto.LoanRequestDto;
import com.mini.springlv2library.dto.LoanResponseDto;
import com.mini.springlv2library.entity.Book;
import com.mini.springlv2library.entity.Loan;
import com.mini.springlv2library.entity.Member;
import com.mini.springlv2library.repository.BookRepository;
import com.mini.springlv2library.repository.LoanRepository;
import com.mini.springlv2library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DtoConverter dtoConverter;

    public boolean loanBook(LoanRequestDto loanRequestDto) {
        Long bookId = loanRequestDto.getBookId();
        Long memberId = loanRequestDto.getMemberId();

        if (loanRepository.existsByBookIdAndReturnStatusFalse(bookId) ||
                loanRepository.existsByMemberIdAndReturnStatusFalse(memberId)) {
            return false;
        }

        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setReturnStatus(false);
        loan.setLoanDate(LocalDate.now());
        loanRepository.save(loan);

        return true;
    }

    public boolean returnBook(LoanRequestDto loanRequestDto) {
        Long bookId = loanRequestDto.getBookId();
        Long memberId = loanRequestDto.getMemberId();

        List<Loan> loans = loanRepository.findByMemberIdOrderByLoanDateAsc(memberId);
        for (Loan loan : loans) {
            if (loan.getBook().getId().equals(bookId) && !loan.isReturnStatus()) {
                loan.setReturnStatus(true);
                loan.setReturnDate(LocalDate.now());
                loanRepository.save(loan);
                return true;
            }
        }
        return false;
    }

    public List<LoanResponseDto> getLoans(Long memberId) {
        return loanRepository.findByMemberIdOrderByLoanDateAsc(memberId)
                .stream()
                .map(dtoConverter::convertToLoanResponseDto)
                .collect(Collectors.toList());
    }
}
