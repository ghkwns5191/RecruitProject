package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Apply;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguagesApplyDto {

    public Apply apply; // 이력서 고유값(Foreign key)

    public String languages; // 언어 명

    public String leveltalking; // 어학 회화능력

    public String levelwriting; // 어학 작문독해능력

    public String test; // 어학 시험명

    public String score; // 어학 시험점수 및 등급

    public LocalDate achievedate; // 어학 시험점수 취득일

    public String certificatenumber; // 어학 시험성적표 번호
    
    public LanguagesApplyDto() {
        // TODO Auto-generated constructor stub
    }

    public LanguagesApplyDto(Apply apply, String languages, String leveltalking, String levelwriting, String test,
            String score, LocalDate achievedate, String certificatenumber) {
       
        this.apply = apply;
        this.languages = languages;
        this.leveltalking = leveltalking;
        this.levelwriting = levelwriting;
        this.test = test;
        this.score = score;
        this.achievedate = achievedate;
        this.certificatenumber = certificatenumber;
    }
    
    

}
