package com.mini.springlv2library.repository;

import com.mini.springlv2library.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByPersonalNumber(String personalNumber);
    boolean existsByPhoneNumber(String phoneNumber);
}
