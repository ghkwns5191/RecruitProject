package com.example.demo.recruit.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyDto {

    
    public Member member; // 회원 고유값(Foreign key)

    public String name; // 지원자 성명

    public String phone; // 지원자 연락처
 
    public String email; // 지원자 이메일

    public LocalDate birthday; // 지원자 생년월일

    public String address; // 지원자 주소

    public String title; // 지원자 이력서 제목

    public String cv;// 지원자 이력서 자기소개서

    public LocalDate applydate; // 지원날짜
    public ApplyDto() {

    }
    public ApplyDto(Member member, String name, String phone, String email, LocalDate birthday, String address,
            String title, String cv, LocalDate applydate) {
        
        this.member = member;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.title = title;
        this.cv = cv;
        this.applydate = applydate;
    }

    

}
