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
@Table(name = "notice")
@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 공지사항 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    @NotNull
    public Member member; // 회원 고유값(Foreign key)

    @Column(length = 200, name = "title")
    @NotNull
    public String title; // 공지사항 제목

    @Column(length = 5000, name = "detail")
    @NotNull
    public String detail; // 공지사항 상세내용

    @Column(name = "registerdate")
    @NotNull
    public LocalDate registerdate; // 공지사항 작성일

    @Column(name = "modifydate")
    public LocalDate modifydate; // 공지사항 수정일

    public Notice() {

    }

    public Notice(@NotNull Member member, @NotNull String title, @NotNull String detail,
            @NotNull LocalDate registerdate, LocalDate modifydate) {

        this.member = member;
        this.title = title;
        this.detail = detail;
        this.registerdate = registerdate;
        this.modifydate = modifydate;
    }

}
