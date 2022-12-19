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
public class Academic {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_academic")
    public Long id_academic; // 학력정보 고유값
    
    @JoinColumn(name = "id_resume")
    public Long id_resume; // 이력서 고유값(Foreign key)
    
    @Column(name = "academic_start")
    public LocalDate academic_start;// 학력 시작일
    
    @Column(name = "academic_end")
    public LocalDate academic_end;// 학력 종료일
    
    @Column(length = 100, name = "academic_studying")
    public String academic_studying;// 졸업 여부
    
    @Column(length = 100, name = "academic_type")
    public String academic_type;// 구분 (고등학교, 대학교, 대학원)

    @Column(length = 100, name = "academic_name")
    public String academic_name;// 학교명
    
    @Column(length = 100, name = "academic_major")
    public String academic_major;// 전공
    
    @Column(length = 100, name = "academic_grade")
    public String academic_grade;// 학점
    
    @Column(length = 100, name = "academic_gradefull")
    public String academic_gradefull;// 학점 총점
    
    @Column(length = 1000, name = "academic_detail")
    public String academic_detail;// 경력여부
    
}
