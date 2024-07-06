package com.mini.springlv2library.service;

import com.mini.springlv2library.dto.DtoConverter;
import com.mini.springlv2library.dto.MemberRequestDto;
import com.mini.springlv2library.dto.MemberResponseDto;
import com.mini.springlv2library.entity.Member;
import com.mini.springlv2library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DtoConverter dtoConverter;

    public MemberResponseDto registerMember(MemberRequestDto memberRequestDto) {
        if (memberRepository.existsByPersonalNumber(memberRequestDto.getPersonalNumber()) ||
                memberRepository.existsByPhoneNumber(memberRequestDto.getPhoneNumber())) {
            throw new IllegalArgumentException("주민번호 또는 전화번호가 중복됩니다.");
        }
        Member member = new Member();
        member.setName(memberRequestDto.getName());
        member.setGender(memberRequestDto.getGender());
        member.setPersonalNumber(memberRequestDto.getPersonalNumber());
        member.setPhoneNumber(memberRequestDto.getPhoneNumber());
        member.setAddress(memberRequestDto.getAddress());
        Member savedMember = memberRepository.save(member);
        return dtoConverter.convertToMemberResponseDto(savedMember.withoutSensitiveData());
    }

    public MemberResponseDto getMember(Long id) {
        return memberRepository.findById(id)
                .map(member -> dtoConverter.convertToMemberResponseDto(member.withoutSensitiveData()))
                .orElse(null);
    }
}
