package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecruitDto {

    public Member id_member; // 회원 고유값(Foreign key)

    public String recruit_title;// 제목

    public String recruit_writer;// 작성자

    public LocalDate recruit_registerdate;// 작성일

    public LocalDate recruit_modifydate;// 수정일

    public String recruit_career;// 경력여부

    public String recruit_salary;// 연봉 or 월급

    public String recruit_workingdays;// 근무일자 ==> 월~금, 월~토, 기타

    public String recruit_detail;// 상세내용

    public String recruit_phonenumber; // 공고 연락처

    public String recruit_attn; // 채용공고 담당자
    
    public RecruitDto() {
        
    }

    public RecruitDto(Member id_member, String recruit_title, String recruit_writer, LocalDate recruit_registerdate,
            LocalDate recruit_modifydate, String recruit_career, String recruit_salary, String recruit_workingdays,
            String recruit_detail, String recruit_phonenumber, String recruit_attn) {
       
        this.id_member = id_member;
        this.recruit_title = recruit_title;
        this.recruit_writer = recruit_writer;
        this.recruit_registerdate = recruit_registerdate;
        this.recruit_modifydate = recruit_modifydate;
        this.recruit_career = recruit_career;
        this.recruit_salary = recruit_salary;
        this.recruit_workingdays = recruit_workingdays;
        this.recruit_detail = recruit_detail;
        this.recruit_phonenumber = recruit_phonenumber;
        this.recruit_attn = recruit_attn;
    }
    
    
}
