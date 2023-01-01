package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EducationDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public LocalDate start; // 교육 시작일

    public LocalDate end; // 교육 종료일

    public String title; // 수료 교육명

    public String holdby; // 교육기관명

    public String detail; // 상세 교육내용

    public EducationDto() {

    }

    public EducationDto(Resume resume, LocalDate start, LocalDate end, String title, String holdby, String detail) {
        super();
        this.resume = resume;
        this.start = start;
        this.end = end;
        this.title = title;
        this.holdby = holdby;
        this.detail = detail;
    }

}
