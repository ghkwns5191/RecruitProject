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
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notice")
    public Long id_notice; // 공지사항 고유값
    
    @JoinColumn(name = "id_member")
    public Long id_member; // 회원 고유값(Foreign key)
    
    @Column(length = 200, name = "notice_title")
    public String notice_title; // 수료 교육명
    
    @Column(length = 5000, name = "notice_detail")
    public String notice_detail; // 상세 교육내용
    
    @Column(name = "notice_registerdate")
    public LocalDate notice_registerdate; // 교육 시작일
    
    @Column(name = "notice_modifydate")
    public LocalDate notice_modifydate; // 교육 종료일
    
    public Notice() {
        
    }

    public Notice(Long id_member, String notice_title, String notice_detail, LocalDate notice_registerdate,
            LocalDate notice_modifydate) {
        
        this.id_member = id_member;
        this.notice_title = notice_title;
        this.notice_detail = notice_detail;
        this.notice_registerdate = notice_registerdate;
        this.notice_modifydate = notice_modifydate;
    }
    
    
}
