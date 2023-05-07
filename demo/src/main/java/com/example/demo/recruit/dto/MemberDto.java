package com.example.demo.recruit.dto;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDto {

    public String sort; // 회원 종류 (개인 or 기업)

    public String username; // 회원 사용자명 (회원 기준 ID)

    public String password; // 회원 비밀번호

    public String name; // 회원 성명

    public String phone; // 회원 연락처

    public String email; // 회원 이메일

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate birthday; // 회원 생년월일

    public String address; // 회원 주소

    public MemberDto() {

    }

    public MemberDto(String sort, String username, String password, String name, String phone, String email,
            LocalDate birthday, String address) {

        this.sort = sort;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        
    }

    public MemberDto(String password, String name, String phone, String email, LocalDate birthday, String address) {
        super();
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }
    
    

}
