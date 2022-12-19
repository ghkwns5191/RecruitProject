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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_education")
    public Long id_education; // 교육내용 고유값
    
    @JoinColumn(name = "id_resume")
    public Long id_resume; // 이력서 고유값(Foreign key)
    
    @Column(name = "education_start")
    public LocalDate education_start; // 교육 시작일
    
    @Column(name = "education_end")
    public LocalDate education_end; // 교육 종료일
    
    @Column(length = 100, name = "education_title")
    public String education_title; // 수료 교육명
    
    @Column(length = 100, name = "education_holdby")
    public String education_holdby; // 교육기관명

    @Column(length = 2000, name = "education_detail")
    public String education_detail; // 상세 교육내용
    
    public Education() {
        
    }

    public Education(Long id_resume, LocalDate education_start, LocalDate education_end, String education_title,
            String education_holdby, String education_detail) {
        
        this.id_resume = id_resume;
        this.education_start = education_start;
        this.education_end = education_end;
        this.education_title = education_title;
        this.education_holdby = education_holdby;
        this.education_detail = education_detail;
    }
    
    
}
