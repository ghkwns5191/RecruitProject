package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OverseasexperienceDto {

    public Resume id_resume; // 이력서 고유값(Foreign key)

    public LocalDate overseasexperience_start; // 해외경험 시작일

    public LocalDate overseasexperience_end; // 해외경험 종료일

    public String overseasexperience_staying; // 해외경험 체류중 여부

    public String overseasexperience_country; // 해외경험 국가명

    public String overseasexperience_detail; // 해외경험 상세내용

    public OverseasexperienceDto() {

    }

    public OverseasexperienceDto(Resume id_resume, LocalDate overseasexperience_start,
            LocalDate overseasexperience_end, String overseasexperience_staying, String overseasexperience_country,
            String overseasexperience_detail) {

        this.id_resume = id_resume;
        this.overseasexperience_start = overseasexperience_start;
        this.overseasexperience_end = overseasexperience_end;
        this.overseasexperience_staying = overseasexperience_staying;
        this.overseasexperience_country = overseasexperience_country;
        this.overseasexperience_detail = overseasexperience_detail;
    }

}
