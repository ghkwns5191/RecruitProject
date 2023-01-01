package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyreviewDto {

    public Company company; // 기업 고유값(Foreign key)

    public Member member; // 회원 고유값(Foreign key)

    public String strength; // 기업리뷰 장점

    public String weakness; // 기업리뷰 단점

    public String reviewdetail; // 기업리뷰 총평

    public Double score; // 기업리뷰 평점

    public CompanyreviewDto() {

    }

    public CompanyreviewDto(Company company, Member member, String strength, String weakness, String reviewdetail,
            Double score) {

        this.company = company;
        this.member = member;
        this.strength = strength;
        this.weakness = weakness;
        this.reviewdetail = reviewdetail;
        this.score = score;
    }

}
