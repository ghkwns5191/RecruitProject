package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

    public Member member; // 회원 고유값(Foreign key)

    public String name; // 기업명

    public String type; // 업종

    public String address; // 기업 주소

    public String phone; // 기업 전화번호

    public String pp20number;// pp20 번호

    public String numberofstaff; // 기업 직원수

    public LocalDate modifydate; // 기업 정보 업데이트일

    public CompanyDto() {

    }

    public CompanyDto(Member member, String name, String type, String address, String phone, String pp20number,
            String numberofstaff, LocalDate modifydate) {

        this.member = member;
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.pp20number = pp20number;
        this.numberofstaff = numberofstaff;
        this.modifydate = modifydate;
    }

}
