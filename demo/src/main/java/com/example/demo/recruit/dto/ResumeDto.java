package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResumeDto {

    public Member id_member; // 회원 고유값(Foreign key)

    public String resume_photo;// 이력서 사진

    public String resume_cv;// 이력서 자기소개서

    public String resume_openforheadhunter;// 이력서 공개여부

    public ResumeDto() {

    }

    public ResumeDto(Member id_member, String resume_photo, String resume_cv, String resume_openforheadhunter) {

        this.id_member = id_member;
        this.resume_photo = resume_photo;
        this.resume_cv = resume_cv;
        this.resume_openforheadhunter = resume_openforheadhunter;
    }

}
