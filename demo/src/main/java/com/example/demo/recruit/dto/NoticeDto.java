package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeDto {

    public Member member; // 회원 고유값(Foreign key)

    public String title; // 공지사항 제목

    public String detail; // 공지사항 상세내용

    public LocalDate registerdate; // 공지사항 작성일

    public LocalDate modifydate; // 공지사항 수정일

    public NoticeDto() {

    }

    public NoticeDto(Member member, String title, String detail, LocalDate registerdate, LocalDate modifydate) {

        this.member = member;
        this.title = title;
        this.detail = detail;
        this.registerdate = registerdate;
        this.modifydate = modifydate;
    }

}
