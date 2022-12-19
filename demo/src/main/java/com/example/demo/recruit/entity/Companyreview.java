package com.example.demo.recruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Companyreview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_companyreview")
    public Long id_companyreview; // 기업리뷰 고유값
    
    @JoinColumn(name = "id_company")
    public Long id_company; // 기업 고유값(Foreign key)
    
    @JoinColumn(name = "id_member")
    public Long id_member; // 회원 고유값(Foreign key)
    
    @Column(length = 100, name = "companyreview_strength")
    public String companyreview_strength; // 기업리뷰 장점
    
    @Column(length = 100, name = "companyreview_weakness")
    public String companyreview_weakness; // 기업리뷰 단점
    
    @Column(length = 100, name = "companyreview_reviewdetail")
    public String companyreview_reviewdetail; // 기업리뷰 총평
    
    @Column(name = "education_holdby")
    public Double companyreview_score; // 기업리뷰 평점
    
    public Companyreview() {
        
    }

    public Companyreview(Long id_company, Long id_member, String companyreview_strength, String companyreview_weakness,
            String companyreview_reviewdetail, Double companyreview_score) {
        
        this.id_company = id_company;
        this.id_member = id_member;
        this.companyreview_strength = companyreview_strength;
        this.companyreview_weakness = companyreview_weakness;
        this.companyreview_reviewdetail = companyreview_reviewdetail;
        this.companyreview_score = companyreview_score;
    }
    
    
}