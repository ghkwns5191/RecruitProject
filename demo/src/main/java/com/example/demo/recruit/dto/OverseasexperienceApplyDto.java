package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Apply;

public class OverseasexperienceApplyDto {

    public Apply apply; // 이력서 고유값(Foreign key)

    public LocalDate start; // 해외경험 시작일

    public LocalDate end; // 해외경험 종료일

    public String staying; // 해외경험 체류중 여부

    public String country; // 해외경험 국가명

    public String detail; // 해외경험 상세내용
    
    public OverseasexperienceApplyDto() {
        // TODO Auto-generated constructor stub
    }

    public OverseasexperienceApplyDto(Apply apply, LocalDate start, LocalDate end, String staying, String country,
            String detail) {
        
        this.apply = apply;
        this.start = start;
        this.end = end;
        this.staying = staying;
        this.country = country;
        this.detail = detail;
    }
    
    
}
