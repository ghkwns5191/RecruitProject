package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PortfolioDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public String title; // 포트폴리오 제목

    public String url1; // 포트폴리오 링크1

    public String url2; // 포트폴리오 링크2

    public PortfolioDto() {

    }

    public PortfolioDto(Resume resume, String title, String url1, String url2) {

        this.resume = resume;
        this.title = title;
        this.url1 = url1;
        this.url2 = url2;
    }

}
