package com.mini.springlv2library.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LoanResponseDto {
    private Long id;
    private Long bookId;
    private Long memberId;
    private boolean returnStatus;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
