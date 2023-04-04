package com.example.demo.recruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "portfolioapply")
@Entity
public class PortfolioApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 포트폴리오 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apply")
    @NotNull
    public Apply apply; // 이력서 고유값(Foreign key)

    @Column(length = 200, name = "title")
    @NotNull
    public String title; // 포트폴리오 제목

    @Column(length = 200, name = "url1")
    public String url1; // 포트폴리오 링크1

    @Column(length = 200, name = "url2")
    public String url2; // 포트폴리오 링크2
    
    public PortfolioApply() {
        // TODO Auto-generated constructor stub
    }

    public PortfolioApply(@NotNull Apply apply, @NotNull String title, String url1, String url2) {
        
        this.apply = apply;
        this.title = title;
        this.url1 = url1;
        this.url2 = url2;
    }
    
    
}
