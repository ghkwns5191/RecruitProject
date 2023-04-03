package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Apply;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Academic_applyDto {

    public Apply apply; // 이력서 고유값(Foreign key)

    public LocalDate start;// 학력 시작일

    public LocalDate end;// 학력 종료일

    public String studying;// 졸업 여부

    public String type;// 구분 (고등학교, 대학교, 대학원)

    public String name;// 학교명

    public String major;// 전공

    public String grade;// 학점

    public String gradefull;// 학점 총점

    public String detail;// 학력 상세내용
    
    public Academic_applyDto() {
        // TODO Auto-generated constructor stub
    }

    public Academic_applyDto(Apply apply, LocalDate start, LocalDate end, String studying, String type, String name,
            String major, String grade, String gradefull, String detail) {
       
        this.apply = apply;
        this.start = start;
        this.end = end;
        this.studying = studying;
        this.type = type;
        this.name = name;
        this.major = major;
        this.grade = grade;
        this.gradefull = gradefull;
        this.detail = detail;
    }
    
    
}
