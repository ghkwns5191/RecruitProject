package com.example.demo.recruit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "apply")
@Entity
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 지원 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    @NotNull
    public Member member; // 회원 고유값(Foreign key)

    @NotNull
    @Column(name = "name")
    public String name; // 지원자 성명

    @NotNull
    @Column(name = "phone")
    public String phone; // 지원자 연락처
    
    @NotNull
    @Column(name = "email")
    public String email; // 지원자 이메일
    
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    public LocalDate birthday; // 지원자 생년월일
    
    @Column(name = "address")
    public String address; // 지원자 주소
    
    @Column(length = 500, name = "title")
    @NotNull
    public String title; // 지원자 이력서 제목
    
    @Column(length = 4000, name = "cv")
    public String cv;// 지원자 이력서 자기소개서
    
    @Column(name = "applydate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate applydate; // 지원날짜

    public Apply() {
        
    }

    public Apply(@NotNull Member member, @NotNull String name, @NotNull String phone, @NotNull String email,
            @NotNull LocalDate birthday, String address, @NotNull String title, String cv, LocalDate applydate) {
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
