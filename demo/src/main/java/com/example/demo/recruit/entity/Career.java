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
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_career")
    public Long id_career; // 경력사항 고유값
    
    @JoinColumn(name = "id_resume")
    public Long id_resume; // 이력서 고유값(Foreign key)
    
    @Column(name = "career_start")
    public LocalDate career_start;// 경력 시작일
    
    @Column(name = "career_end")
    public LocalDate career_end;// 경력 종료일
    
    @Column(length = 100, name = "career_working")
    public String career_working;// 재직중 여부 (재직중 or 퇴사)
    
    @Column(length = 100, name = "career_companyname")
    public String career_companyname;// 회사 이름
    
    @Column(length = 100, name = "career_rank")
    public String career_rank;// 근무 직급
    
    @Column(length = 100, name = "career_salary")
    public String career_salary;// 연봉/월급정보
    
    @Column(length = 100, name = "career_jobduty")
    public String career_jobduty;// 직무부서
    
    @Column(length = 2000, name = "career_detail")
    public String career_detail;// 경력 상세내용
    
    public Career() {
        
    }

    public Career(Long id_resume, LocalDate career_start, LocalDate career_end, String career_working,
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
