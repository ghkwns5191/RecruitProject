package com.example.demo.recruit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "member", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "phone"),
        @UniqueConstraint(columnNames = "email")
})
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 회원 고유값(Primary key)

    @Column(length = 100, name = "sort")
    @NotNull
    public String sort; // 회원 종류 (개인 or 기업)

    @Column(length = 100, name = "username")
    @NotNull
    public String username; // 회원 사용자명 (회원 기준 ID)

    @Column(length = 100, name = "password")
    @NotNull
    public String password; // 회원 비밀번호

    @Column(length = 100, name = "name")
    @NotNull
    public String name; // 회원 성명

    @Column(length = 100, name = "phone")
    public String phone; // 회원 연락처

    @Column(length = 100, name = "email")
    public String email; // 회원 이메일

    @Column(name = "birthday")
    public LocalDate birthday; // 회원 생년월일

    @Column(length = 500, name = "address")
    public String address; // 회원 주소

    @Column(name = "registerdate")
    public LocalDate registerdate; // 회원 가입일

    @Enumerated(EnumType.STRING)
    private ERole role;

    public Member() {

    }

    public Member(@NotNull String sort, @NotNull String username, @NotNull String password, @NotNull String name,
            String phone, String email, LocalDate birthday, String address, LocalDate registerdate, ERole role) {
        
        this.sort = sort;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.registerdate = registerdate;
        this.role = role;
    }
    
    

}
