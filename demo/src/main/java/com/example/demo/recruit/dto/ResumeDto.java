package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeDto {

    private Member member; // 회원 고유값(Foreign key)

    private String cv;// 이력서 자기소개서

    private String openforheadhunter;// 이력서 공개여부
    
    public ResumeDto() {
        // TODO Auto-generated constructor stub
    }

    

    public ResumeDto(Member member, String cv, String openforheadhunter) {

        this.member = member;
        this.cv = cv;
        this.openforheadhunter = openforheadhunter;
    }

}
