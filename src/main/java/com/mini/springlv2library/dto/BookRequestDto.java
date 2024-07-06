package com.mini.springlv2library.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookRequestDto {
    private String title;
    private String author;
    private String language;
    private String publisher;
    private LocalDate registrationDate;
}
