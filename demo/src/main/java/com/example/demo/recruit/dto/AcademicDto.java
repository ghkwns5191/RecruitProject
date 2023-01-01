package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademicDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public LocalDate academic_start;// 학력 시작일

    public LocalDate academic_end;// 학력 종료일

    public String academic_studying;// 졸업 여부

    public String academic_type;// 구분 (고등학교, 대학교, 대학원)

    public String academic_name;// 학교명

    public String academic_major;// 전공

    public String academic_grade;// 학점

    public String academic_gradefull;// 학점 총점

    public String academic_detail;// 학력 상세내용

    public AcademicDto() {
        // TODO Auto-generated constructor stub
    }

    public AcademicDto(Resume resume, LocalDate academic_start, LocalDate academic_end, String academic_studying,
            String academic_type, String academic_name, String academic_major, String academic_grade,
            String academic_gradefull, String academic_detail) {
        super();
        this.resume = resume;
        this.academic_start = academic_start;
        this.academic_end = academic_end;
        this.academic_studying = academic_studying;
        this.academic_type = academic_type;
        this.academic_name = academic_name;
        this.academic_major = academic_major;
        this.academic_grade = academic_grade;
        this.academic_gradefull = academic_gradefull;
        this.academic_detail = academic_detail;
    }

}
