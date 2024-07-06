package com.mini.springlv2library.controller;

import com.mini.springlv2library.dto.MemberRequestDto;
import com.mini.springlv2library.dto.MemberResponseDto;
import com.mini.springlv2library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> registerMember(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(memberService.registerMember(memberRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }
}