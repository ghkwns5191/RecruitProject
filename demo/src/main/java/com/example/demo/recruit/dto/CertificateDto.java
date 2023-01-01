package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificateDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public LocalDate certificate_achievedate; // 자격증 취득일

    public String certificate_name; // 자격증명

    public String certificate_grade; // 자격증 등급 및 점수

    public String certificate_achievefrom; // 자격증 발급처

    public String certificate_certificatenumber; // 자격증 번호

    public CertificateDto() {

    }

    public CertificateDto(Resume resume, LocalDate certificate_achievedate, String certificate_name,
            String certificate_grade, String certificate_achievefrom, String certificate_certificatenumber) {
        
        this.resume = resume;
        this.certificate_achievedate = certificate_achievedate;
        this.certificate_name = certificate_name;
        this.certificate_grade = certificate_grade;
        this.certificate_achievefrom = certificate_achievefrom;
        this.certificate_certificatenumber = certificate_certificatenumber;
    }

    

}
