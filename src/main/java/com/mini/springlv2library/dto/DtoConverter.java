package com.mini.springlv2library.dto;

import com.mini.springlv2library.entity.Book;
import com.mini.springlv2library.entity.Loan;
import com.mini.springlv2library.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {
    public BookResponseDto convertToBookResponseDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setLanguage(book.getLanguage());
        dto.setPublisher(book.getPublisher());
        dto.setRegistrationDate(book.getRegistrationDate());
        return dto;
    }

    public MemberResponseDto convertToMemberResponseDto(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setId(member.getId());
        dto.setName(member.getName());
        dto.setGender(member.getGender());
        dto.setPhoneNumber(member.getPhoneNumber());
        dto.setAddress(member.getAddress());
        return dto;
    }

    public LoanResponseDto convertToLoanResponseDto(Loan loan) {
        LoanResponseDto dto = new LoanResponseDto();
        dto.setId(loan.getId());
        dto.setBookId(loan.getBook().getId());
        dto.setMemberId(loan.getMember().getId());
        dto.setReturnStatus(loan.isReturnStatus());
        dto.setLoanDate(loan.getLoanDate());
        dto.setReturnDate(loan.getReturnDate());
        return dto;
    }
}
