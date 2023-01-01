package com.example.demo.recruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "companyreview")
@Entity
public class Companyreview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_companyreview")
    public Long id_companyreview; // 기업리뷰 고유값
    
    @ManyToOne
    @JoinColumn(name = "company")
    public Company company; // 기업 고유값(Foreign key)
    
    @ManyToOne
    @JoinColumn(name = "member")
    @NotNull
    public Member member; // 회원 고유값(Foreign key)
    
    @Column(length = 100, name = "companyreview_strength")
    @NotNull
    public String companyreview_strength; // 기업리뷰 장점
    
    @Column(length = 100, name = "companyreview_weakness")
    @NotNull
    public String companyreview_weakness; // 기업리뷰 단점
    
    @Column(length = 100, name = "companyreview_reviewdetail")
    @NotNull
    public String companyreview_reviewdetail; // 기업리뷰 총평
    
    @Column(name = "education_holdby")
    @NotNull
    public Double companyreview_score; // 기업리뷰 평점
    
    public Companyreview() {
        
    }

    public Companyreview(Company company, Member member, String companyreview_strength,
            String companyreview_weakness, String companyreview_reviewdetail, Double companyreview_score) {
       
        this.company = company;
        this.member = member;
        this.companyreview_strength = companyreview_strength;
        this.companyreview_weakness = companyreview_weakness;
        this.companyreview_reviewdetail = companyreview_reviewdetail;
        this.companyreview_score = companyreview_score;
    }

    
    
    
}
