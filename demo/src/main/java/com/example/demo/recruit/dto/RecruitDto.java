package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecruitDto {

    public Member member; // 회원 고유값(Foreign key)

    public String title;// 제목

    public String writer;// 작성자

    public LocalDate registerdate;// 작성일

    public LocalDate modifydate;// 수정일

    public String career;// 경력여부

    public String salary;// 연봉 or 월급

    public String workingdays;// 근무일자 ==> 월~금, 월~토, 기타

    public String detail;// 상세내용

    public String phonenumber; // 공고 연락처

    public String attn; // 채용공고 담당자
    
    public LocalDate deadline;

    public RecruitDto() {

    }

    public RecruitDto(Member member, String title, String writer, LocalDate registerdate, LocalDate modifydate,
            String career, String salary, String workingdays, String detail, String phonenumber, String attn, LocalDate deadline) {

        this.member = member;
        this.title = title;
        this.writer = writer;
        this.registerdate = registerdate;
        this.modifydate = modifydate;
        this.career = career;
        this.salary = salary;
        this.workingdays = workingdays;
        this.detail = detail;
        this.phonenumber = phonenumber;
        this.attn = attn;
        this.deadline = deadline;
    }

}
