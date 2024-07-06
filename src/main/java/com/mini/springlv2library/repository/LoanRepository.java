package com.mini.springlv2library.repository;

import com.mini.springlv2library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByBookIdAndReturnStatusFalse(Long bookId);
    boolean existsByMemberIdAndReturnStatusFalse(Long memberId);
    List<Loan> findByMemberIdOrderByLoanDateAsc(Long memberId);
}
