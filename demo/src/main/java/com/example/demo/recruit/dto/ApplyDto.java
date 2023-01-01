package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyDto {

    public Member member; // 회원 고유값(Foreign key)

    public Recruit recruit; // 채용공고 고유값(Foreign key)

    public LocalDate applydate; // 지원날짜

    public ApplyDto() {

    }

    public ApplyDto(Member member, Recruit recruit, LocalDate applydate) {

        this.member = member;
        this.recruit = recruit;
        this.applydate = applydate;
    }

}
