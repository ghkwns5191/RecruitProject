package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LanguagesDto {

    public Resume resume; // 이력서 고유값(Foreign key)
    
    public String languages; //  언어 명

    public String leveltalking; // 어학 회화능력

    public String levelwriting; // 어학 작문독해능력

    public String test; // 어학 시험명

    public String score; // 어학 시험점수 및 등급

    public LocalDate achievedate; // 어학 시험점수 취득일

    public String certificatenumber; // 어학 시험성적표 번호

    public LanguagesDto() {

    }

    public LanguagesDto(Resume resume, String languages, String leveltalking, String levelwriting, String test, String score,
            LocalDate achievedate, String certificatenumber) {

        this.resume = resume;
        this.languages = languages;
        this.leveltalking = leveltalking;
        this.levelwriting = levelwriting;
        this.test = test;
        this.score = score;
        this.achievedate = achievedate;
        this.certificatenumber = certificatenumber;
    }

}
