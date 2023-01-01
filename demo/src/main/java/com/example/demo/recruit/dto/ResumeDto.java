package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResumeDto {

    public Member member; // 회원 고유값(Foreign key)

    public String photo;// 이력서 사진

    public String cv;// 이력서 자기소개서

    public String openforheadhunter;// 이력서 공개여부

    public ResumeDto() {

    }

    public ResumeDto(Member member, String photo, String cv, String openforheadhunter) {

        this.member = member;
        this.photo = photo;
        this.cv = cv;
        this.openforheadhunter = openforheadhunter;
    }

}
