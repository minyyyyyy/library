package com.mini.springlv2library.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private String personalNumber;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Loan> loans;

    public Member withoutSensitiveData() {
        this.personalNumber = null;
        return this;
    }
}
