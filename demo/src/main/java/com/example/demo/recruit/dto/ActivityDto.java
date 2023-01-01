package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivityDto {

    public Resume resume; // 이력서 고유값(Foreign key)

    public LocalDate start; // 대외활동 시작일

    public LocalDate end; // 대외활동 종료일

    public String title; // 대외활동명

    public String holdby; // 대외활동 주최단체

    public String detail; // 대외활동 상세활동내역

    public ActivityDto() {
        // TODO Auto-generated constructor stub
    }

    public ActivityDto(Resume resume, LocalDate start, LocalDate end, String title, String holdby, String detail) {

        this.resume = resume;
        this.start = start;
        this.end = end;
        this.title = title;
        this.holdby = holdby;
        this.detail = detail;
    }

}
