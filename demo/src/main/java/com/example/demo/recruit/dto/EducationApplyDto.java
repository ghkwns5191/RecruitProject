package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Apply;

public class EducationApplyDto {

    public Apply apply; // 이력서 고유값(Foreign key)

    public LocalDate start; // 교육 시작일

    public LocalDate end; // 교육 종료일

    public String title; // 수료 교육명

    public String holdby; // 교육기관명

    public String detail; // 상세 교육내용
    
    public EducationApplyDto() {
        // TODO Auto-generated constructor stub
    }

    public EducationApplyDto(Apply apply, LocalDate start, LocalDate end, String title, String holdby, String detail) {
     
        this.apply = apply;
        this.start = start;
        this.end = end;
        this.title = title;
        this.holdby = holdby;
        this.detail = detail;
    }
    
    
    
}
