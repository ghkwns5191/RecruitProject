package com.example.demo.recruit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "id_notice")
    public Long id_notice; // 공지사항 고유값
    
    @ManyToOne
    @JoinColumn(name = "id_member")
    @NotNull
    public Member id_member; // 회원 고유값(Foreign key)
    
    @Column(length = 200, name = "notice_title")
    @NotNull
    public String notice_title; // 공지사항 제목
    
    @Column(length = 5000, name = "notice_detail")
    @NotNull
    public String notice_detail; // 공지사항 상세내용
    
    @Column(name = "notice_registerdate")
    @NotNull
    public LocalDate notice_registerdate; // 공지사항 작성일
    
    @Column(name = "notice_modifydate")
    public LocalDate notice_modifydate; // 공지사항 수정일
    
    public Notice() {
        
    }

    public Notice(Member id_member, String notice_title, String notice_detail, LocalDate notice_registerdate,
            LocalDate notice_modifydate) {
        
        this.id_member = id_member;
        this.notice_title = notice_title;
        this.notice_detail = notice_detail;
        this.notice_registerdate = notice_registerdate;
        this.notice_modifydate = notice_modifydate;
    }

    
    
    
}
