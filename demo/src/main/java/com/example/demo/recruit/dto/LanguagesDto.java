package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LanguagesDto {

    public Resume id_resume; // 이력서 고유값(Foreign key)

    public String languages_leveltalking; // 어학 회화능력

    public String languages_levelwriting; // 어학 작문독해능력

    public String languages_test; // 어학 시험명

    public String languages_score; // 어학 시험점수 및 등급

    public LocalDate languages_achievedate; // 어학 시험점수 취득일

    public String languages_certificatenumber; // 어학 시험성적표 번호
    
    public LanguagesDto() {
        
    }

    public LanguagesDto(Resume id_resume, String languages_leveltalking, String languages_levelwriting,
            String languages_test, String languages_score, LocalDate languages_achievedate,
            String languages_certificatenumber) {
        
        this.id_resume = id_resume;
        this.languages_leveltalking = languages_leveltalking;
        this.languages_levelwriting = languages_levelwriting;
        this.languages_test = languages_test;
        this.languages_score = languages_score;
        this.languages_achievedate = languages_achievedate;
        this.languages_certificatenumber = languages_certificatenumber;
    }
    
    
}
