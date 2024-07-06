package com.mini.springlv2library.dto;

import lombok.Data;

@Data
public class MemberRequestDto {
    private String name;
    private String gender;
    private String personalNumber;
    private String phoneNumber;
    private String address;
}
