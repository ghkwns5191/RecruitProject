package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeDto {

    private Member member; // 회원 고유값(Foreign key)
    
    public String title;

    private String cv;// 이력서 자기소개서

    private String openforheadhunter;// 이력서 공개여부

    public ResumeDto() {
        // TODO Auto-generated constructor stub
    }

    public ResumeDto(Member member, String title, String cv, String openforheadhunter) {

        this.member = member;
        this.title = title;
        this.cv = cv;
        this.openforheadhunter = openforheadhunter;
    }
    
    public ResumeDto(String title) {

        this.title = title;
    }

}
