package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Apply;

public class CareerApplyDto {

    public Apply apply; // 이력서 고유값(Foreign key)

    public LocalDate start;// 경력 시작일

    public LocalDate end;// 경력 종료일

    public String working;// 재직중 여부 (재직중 or 퇴사)

    public String companyname;// 회사 이름

    public String ranks;// 근무 직급

    public String salary;// 연봉/월급정보

    public String jobduty;// 직무부서

    public String detail;// 경력 상세내용
    
    public CareerApplyDto() {
        // TODO Auto-generated constructor stub
    }

    public CareerApplyDto(Apply apply, LocalDate start, LocalDate end, String working, String companyname, String ranks,
            String salary, String jobduty, String detail) {
        
        this.apply = apply;
        this.start = start;
        this.end = end;
        this.working = working;
        this.companyname = companyname;
        this.ranks = ranks;
        this.salary = salary;
        this.jobduty = jobduty;
        this.detail = detail;
    }
    
    
    
}
