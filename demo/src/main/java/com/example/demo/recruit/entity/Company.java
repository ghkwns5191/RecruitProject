package com.example.demo.recruit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    public Long id_company; // 기업 고유값
    
    @JoinColumn(name = "id_member")
    public Long id_member; // 회원 고유값(Foreign key)
    
    @Column(length = 100, name = "company_name")
    public String company_name; // 기업명
    
    @Column(length = 100, name = "company_type")
    public String company_type; // 업종
    
    @Column(length = 500, name = "company_address")
    public String company_address; // 기업 주소

    @Column(length = 100, name = "company_phone")
    public String company_phone; // 기업 전화번호
    
    @Column(length = 100, name = "company_pp20number")
    public String company_pp20number;// pp20 번호
    
    @Column(length = 100, name = "company_numberofstaff")
    public String company_numberofstaff; // 기업 직원수
    
    @Column(name = "company_modifydate")
    public LocalDate company_modifydate; // 기업 정보 업데이트일
    
    public Company() {
        
    }

    public Company(Long id_member, String company_name, String company_type, String company_address,
            String company_phone, String company_pp20number, String company_numberofstaff,
            LocalDate company_modifydate) {
        super();
        this.id_member = id_member;
        this.company_name = company_name;
        this.company_type = company_type;
        this.company_address = company_address;
        this.company_phone = company_phone;
        this.company_pp20number = company_pp20number;
        this.company_numberofstaff = company_numberofstaff;
        this.company_modifydate = company_modifydate;
    }
    
    
}
