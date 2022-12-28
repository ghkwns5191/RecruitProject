package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EducationDto {

    public Resume id_resume; // 이력서 고유값(Foreign key)

    public LocalDate education_start; // 교육 시작일

    public LocalDate education_end; // 교육 종료일

    public String education_title; // 수료 교육명

    public String education_holdby; // 교육기관명

    public String education_detail; // 상세 교육내용
    
    public EducationDto() {
        
    }

    public EducationDto(Resume id_resume, LocalDate education_start, LocalDate education_end, String education_title,
            String education_holdby, String education_detail) {
        
        this.id_resume = id_resume;
        this.education_start = education_start;
        this.education_end = education_end;
        this.education_title = education_title;
        this.education_holdby = education_holdby;
        this.education_detail = education_detail;
    }
    
    
}
