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
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity")
    public Long id_activity; // 대외활동 고유값
    
    @JoinColumn(name = "id_resume")
    public Long id_resume; // 이력서 고유값(Foreign key)
    
    @Column(name = "activity_start")
    public LocalDate activity_start; // 대외활동 시작일
    
    @Column(name = "activity_end")
    public LocalDate activity_end; // 대외활동 종료일
    
    @Column(length = 100, name = "activity_title")
    public String activity_title; // 대외활동명
    
    @Column(length = 100, name = "activity_holdby")
    public String activity_holdby; // 대외활동 주최단체

    @Column(length = 2000, name = "activity_detail")
    public String activity_detail; // 대외활동 상세활동내역
    
    public Activity() {
        
    }

    public Activity(Long id_resume, LocalDate activity_start, LocalDate activity_end, String activity_title,
            String activity_holdby, String activity_detail) {
        
        this.id_resume = id_resume;
        this.activity_start = activity_start;
        this.activity_end = activity_end;
        this.activity_title = activity_title;
        this.activity_holdby = activity_holdby;
        this.activity_detail = activity_detail;
    }
    
    
}
