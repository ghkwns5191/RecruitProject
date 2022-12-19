package com.example.demo.recruit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_member")
    public Long id_member; // 회원 고유값(Primary key)
    
    @Column(length = 100, name = "member_sort")
    public String member_sort; // 회원 종류 (개인 or 기업)
    
    @Column(length = 100, name = "member_username")
    public String member_username; // 회원 사용자명 (회원 기준 ID)
    
    @Column(length = 100, name = "member_password")
    public String member_password; // 회원 비밀번호
    
    @Column(length = 100, name = "member_name")
    public String member_name; // 회원 성명
    
    @Column(length = 100, name = "member_phone")
    public String member_phone; // 회원 연락처
    
    @Column(length = 100, name = "member_email")
    public String member_email; // 회원 이메일
    
    @Column(name = "member_birthday")
    public LocalDate member_birthday; // 회원 생년월일
    
    @Column(length = 500, name = "member_address")
    public String member_address; // 회원 주소
    
    @Column(length = 500, name = "member_role")
    public String member_role; // 회원 자격(사용자 or 관리자)
    
    @Column(name = "member_registerdate")
    public LocalDate member_registerdate; // 회원 가입일
    
}
