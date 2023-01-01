package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PortfolioDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public String title; // 포트폴리오 제목

    public String file1; // 포트폴리오 파일1

    public String file2; // 포트폴리오 파일2

    public String url1; // 포트폴리오 링크1

    public String url2; // 포트폴리오 링크2

    public PortfolioDto() {

    }

    public PortfolioDto(Resume resume, String title, String file1, String file2, String url1, String url2) {

        this.resume = resume;
        this.title = title;
        this.file1 = file1;
        this.file2 = file2;
        this.url1 = url1;
        this.url2 = url2;
    }

}
