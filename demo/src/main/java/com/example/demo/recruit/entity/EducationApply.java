package com.example.demo.recruit.entity;

import java.time.LocalDate;

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
@Table(name = "educationapply")
@Entity
public class EducationApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 교육내용 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apply")
    @NotNull
    public Apply apply; // 이력서 고유값(Foreign key)

    @Column(name = "start")
    @NotNull
    public LocalDate start; // 교육 시작일

    @Column(name = "end")
    @NotNull
    public LocalDate end; // 교육 종료일

    @Column(length = 100, name = "title")
    @NotNull
    public String title; // 수료 교육명

    @Column(length = 100, name = "holdby")
    @NotNull
    public String holdby; // 교육기관명

    @Column(length = 2000, name = "detail")
    public String detail; // 상세 교육내용

    public EducationApply() {
        // TODO Auto-generated constructor stub
    }

    public EducationApply(@NotNull Apply apply, @NotNull LocalDate start, @NotNull LocalDate end,
            @NotNull String title, @NotNull String holdby, String detail) {
        
        this.apply = apply;
        this.start = start;
        this.end = end;
        this.title = title;
        this.holdby = holdby;
        this.detail = detail;
    }
    
    
}
