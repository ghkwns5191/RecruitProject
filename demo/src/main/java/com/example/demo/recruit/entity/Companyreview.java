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
    @Column(name = "id")
    public Long id; // 기업리뷰 고유값

    @ManyToOne
    @JoinColumn(name = "company")
    public Company company; // 기업 고유값(Foreign key)

    @ManyToOne
    @JoinColumn(name = "member")
    @NotNull
    public Member member; // 회원 고유값(Foreign key)

    @Column(length = 100, name = "strength")
    @NotNull
    public String strength; // 기업리뷰 장점

    @Column(length = 100, name = "weakness")
    @NotNull
    public String weakness; // 기업리뷰 단점

    @Column(length = 100, name = "reviewdetail")
    @NotNull
    public String reviewdetail; // 기업리뷰 총평

    @Column(name = "score")
    @NotNull
    public Double score; // 기업리뷰 평점

    public Companyreview() {

    }

    public Companyreview(Company company, @NotNull Member member, @NotNull String strength, @NotNull String weakness,
            @NotNull String reviewdetail, @NotNull Double score) {

        this.company = company;
        this.member = member;
        this.strength = strength;
        this.weakness = weakness;
        this.reviewdetail = reviewdetail;
        this.score = score;
    }

}
