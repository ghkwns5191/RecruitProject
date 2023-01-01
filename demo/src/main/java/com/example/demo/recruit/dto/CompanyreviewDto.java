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

    public String companyreview_strength; // 기업리뷰 장점

    public String companyreview_weakness; // 기업리뷰 단점

    public String companyreview_reviewdetail; // 기업리뷰 총평

    public Double companyreview_score; // 기업리뷰 평점
    
    public CompanyreviewDto() {
        
    }

    public CompanyreviewDto(Company company, Member member, String companyreview_strength,
            String companyreview_weakness, String companyreview_reviewdetail, Double companyreview_score) {
        super();
        this.company = company;
        this.member = member;
        this.companyreview_strength = companyreview_strength;
        this.companyreview_weakness = companyreview_weakness;
        this.companyreview_reviewdetail = companyreview_reviewdetail;
        this.companyreview_score = companyreview_score;
    }

    
    
    
}
