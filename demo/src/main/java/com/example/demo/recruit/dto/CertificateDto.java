package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificateDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public LocalDate achievedate; // 자격증 취득일

    public String name; // 자격증명

    public String grade; // 자격증 등급 및 점수

    public String achievefrom; // 자격증 발급처

    public String certificatenumber; // 자격증 번호

    public CertificateDto() {

    }

    public CertificateDto(Resume resume, LocalDate achievedate, String name, String grade, String achievefrom,
            String certificatenumber) {

        this.resume = resume;
        this.achievedate = achievedate;
        this.name = name;
        this.grade = grade;
        this.achievefrom = achievefrom;
        this.certificatenumber = certificatenumber;
    }

}
