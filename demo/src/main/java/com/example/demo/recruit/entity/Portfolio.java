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
@Table(name = "portfolio")
@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_portfolio")
    public Long id_portfolio; // 포트폴리오 고유값
    
    @ManyToOne
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)
    
    @Column(length = 200, name = "portfolio_title")
    @NotNull
    public String portfolio_title; // 포트폴리오 제목
    
    @Column(length = 2000, name = "portfolio_file1")
    public String portfolio_file1; // 포트폴리오 파일1
    
    @Column(length = 2000, name = "portfolio_file2")
    public String portfolio_file2; // 포트폴리오 파일2
    
    @Column(length = 200, name = "portfolio_url1")
    public String portfolio_url1; // 포트폴리오 링크1
    
    @Column(length = 200, name = "portfolio_url2")
    public String portfolio_url2; // 포트폴리오 링크2
    
    public Portfolio() {
        
    }

    public Portfolio(Resume resume, String portfolio_title, String portfolio_file1, String portfolio_file2,
            String portfolio_url1, String portfolio_url2) {
        
        this.resume = resume;
        this.portfolio_title = portfolio_title;
        this.portfolio_file1 = portfolio_file1;
        this.portfolio_file2 = portfolio_file2;
        this.portfolio_url1 = portfolio_url1;
        this.portfolio_url2 = portfolio_url2;
    }

    
    
    
}
