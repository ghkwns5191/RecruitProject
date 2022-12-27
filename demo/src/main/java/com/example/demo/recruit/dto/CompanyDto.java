package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

    public Member id_member; // 회원 고유값(Foreign key)

    public String company_name; // 기업명

    public String company_type; // 업종

    public String company_address; // 기업 주소

    public String company_phone; // 기업 전화번호

    public String company_pp20number;// pp20 번호

    public String company_numberofstaff; // 기업 직원수

    public LocalDate company_modifydate; // 기업 정보 업데이트일

    public CompanyDto() {

    }

    public CompanyDto(Member id_member, String company_name, String company_type, String company_address,
            String company_phone, String company_pp20number, String company_numberofstaff,
            LocalDate company_modifydate) {
        
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
