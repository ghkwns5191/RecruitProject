package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyDto {

    public Member id_member; // 회원 고유값(Foreign key)

    public Recruit id_recruit; // 채용공고 고유값(Foreign key)

    public LocalDate apply_applydate; // 지원날짜

    public ApplyDto() {

    }

    public ApplyDto(Member id_member, Recruit id_recruit, LocalDate apply_applydate) {

        this.id_member = id_member;
        this.id_recruit = id_recruit;
        this.apply_applydate = apply_applydate;
    }

}
