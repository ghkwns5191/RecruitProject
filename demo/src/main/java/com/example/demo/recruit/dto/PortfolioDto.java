package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PortfolioDto {

    public Resume id_resume; // 이력서 고유값(Foreign key)

    public String portfolio_title; // 포트폴리오 제목

    public String portfolio_file1; // 포트폴리오 파일1

    public String portfolio_file2; // 포트폴리오 파일2

    public String portfolio_url1; // 포트폴리오 링크1

    public String portfolio_url2; // 포트폴리오 링크2

    public PortfolioDto() {

    }

    public PortfolioDto(Resume id_resume, String portfolio_title, String portfolio_file1, String portfolio_file2,
            String portfolio_url1, String portfolio_url2) {

        this.id_resume = id_resume;
        this.portfolio_title = portfolio_title;
        this.portfolio_file1 = portfolio_file1;
        this.portfolio_file2 = portfolio_file2;
        this.portfolio_url1 = portfolio_url1;
        this.portfolio_url2 = portfolio_url2;
    }

}
