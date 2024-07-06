package com.mini.springlv2library.dto;

import lombok.Data;

@Data
public class MemberResponseDto {
    private Long id;
    private String name;
    private String gender;
    private String phoneNumber;
    private String address;
}