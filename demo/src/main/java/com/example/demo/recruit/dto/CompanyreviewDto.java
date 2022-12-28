package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyreviewDto {

    public Company id_company; // 기업 고유값(Foreign key)

    public Member id_member; // 회원 고유값(Foreign key)

    public String companyreview_strength; // 기업리뷰 장점

    public String companyreview_weakness; // 기업리뷰 단점

    public String companyreview_reviewdetail; // 기업리뷰 총평

    public Double companyreview_score; // 기업리뷰 평점
    
    public CompanyreviewDto() {
        
    }

    public CompanyreviewDto(Company id_company, Member id_member, String companyreview_strength,
            String companyreview_weakness, String companyreview_reviewdetail, Double companyreview_score) {
       
        this.id_company = id_company;
        this.id_member = id_member;
        this.companyreview_strength = companyreview_strength;
        this.companyreview_weakness = companyreview_weakness;
        this.companyreview_reviewdetail = companyreview_reviewdetail;
        this.companyreview_score = companyreview_score;
    }
    
    
}
