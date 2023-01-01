package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OverseasexperienceDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public LocalDate start; // 해외경험 시작일

    public LocalDate end; // 해외경험 종료일

    public String staying; // 해외경험 체류중 여부

    public String country; // 해외경험 국가명

    public String detail; // 해외경험 상세내용

    public OverseasexperienceDto() {

    }

    public OverseasexperienceDto(Resume resume, LocalDate start, LocalDate end, String staying, String country,
            String detail) {

        this.resume = resume;
        this.start = start;
        this.end = end;
        this.staying = staying;
        this.country = country;
        this.detail = detail;
    }

}
