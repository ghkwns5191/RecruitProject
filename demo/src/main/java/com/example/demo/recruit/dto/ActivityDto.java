package com.example.demo.recruit.dto;

import java.time.LocalDate;

import com.example.demo.recruit.entity.Resume;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivityDto {

    public Resume id_resume; // 이력서 고유값(Foreign key)

    public LocalDate activity_start; // 대외활동 시작일

    public LocalDate activity_end; // 대외활동 종료일

    public String activity_title; // 대외활동명

    public String activity_holdby; // 대외활동 주최단체

    public String activity_detail; // 대외활동 상세활동내역
    
    public ActivityDto() {
        // TODO Auto-generated constructor stub
    }

    public ActivityDto(Resume id_resume, LocalDate activity_start, LocalDate activity_end, String activity_title,
            String activity_holdby, String activity_detail) {
        super();
        this.id_resume = id_resume;
        this.activity_start = activity_start;
        this.activity_end = activity_end;
        this.activity_title = activity_title;
        this.activity_holdby = activity_holdby;
        this.activity_detail = activity_detail;
    }
    
    
}
