package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeDto {

    public Member member; // 회원 고유값(Foreign key)

    public String notice_title; // 공지사항 제목

    public String notice_detail; // 공지사항 상세내용

    public LocalDate notice_registerdate; // 공지사항 작성일

    public LocalDate notice_modifydate; // 공지사항 수정일
    
    public NoticeDto() {
        
    }

    public NoticeDto(Member member, String notice_title, String notice_detail, LocalDate notice_registerdate,
            LocalDate notice_modifydate) {
        
        this.member = member;
        this.notice_title = notice_title;
        this.notice_detail = notice_detail;
        this.notice_registerdate = notice_registerdate;
        this.notice_modifydate = notice_modifydate;
    }

    
    
    
}
