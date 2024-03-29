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

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "company")
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 기업 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    public Member member; // 회원 고유값(Foreign key)

    @Column(length = 100, name = "name", unique = true)
    @NotNull
    public String name; // 기업명

    @Column(length = 100, name = "type")
    @NotNull
    public String type; // 업종

    @Column(length = 500, name = "address")
    @NotNull
    public String address; // 기업 주소

    @Column(length = 100, name = "phone", unique = true)
    @NotNull
    public String phone; // 기업 전화번호

    @Column(length = 100, name = "pp20number")
    public String pp20number;// pp20 번호

    @Column(length = 100, name = "numberofstaff")
    public String numberofstaff; // 기업 직원수

    @Column(name = "modifydate")
    public LocalDate modifydate; // 기업 정보 업데이트일

    public Company() {

    }

    public Company(Member member, @NotNull String name, @NotNull String type, @NotNull String address,
            @NotNull String phone, String pp20number, String numberofstaff, LocalDate modifydate) {

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
