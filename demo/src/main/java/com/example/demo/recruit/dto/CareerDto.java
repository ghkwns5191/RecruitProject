package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CareerDto {

    public Resume id_resume; // 이력서 고유값(Foreign key)

    public LocalDate career_start;// 경력 시작일

    public LocalDate career_end;// 경력 종료일

    public String career_working;// 재직중 여부 (재직중 or 퇴사)

    public String career_companyname;// 회사 이름

    public String career_rank;// 근무 직급

    public String career_salary;// 연봉/월급정보

    public String career_jobduty;// 직무부서

    public String career_detail;// 경력 상세내용

    public CareerDto() {

    }

    public CareerDto(Resume id_resume, LocalDate career_start, LocalDate career_end, String career_working,
            String career_companyname, String career_rank, String career_salary, String career_jobduty,
            String career_detail) {

        this.id_resume = id_resume;
        this.career_start = career_start;
        this.career_end = career_end;
        this.career_working = career_working;
        this.career_companyname = career_companyname;
        this.career_rank = career_rank;
        this.career_salary = career_salary;
        this.career_jobduty = career_jobduty;
        this.career_detail = career_detail;
    }

}
