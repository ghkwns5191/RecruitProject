package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Apply;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioApplyDto {

    public Apply apply; // 이력서 고유값(Foreign key)

    public String title; // 포트폴리오 제목

    public String url1; // 포트폴리오 링크1

    public String url2; // 포트폴리오 링크2

    public PortfolioApplyDto() {
        // TODO Auto-generated constructor stub
    }

    public PortfolioApplyDto(Apply apply, String title, String url1, String url2) {
        super();
        this.apply = apply;
        this.title = title;
        this.url1 = url1;
        this.url2 = url2;
    }

}
