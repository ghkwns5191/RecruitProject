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
@Table(name = "activity_apply")
@Entity
public class Activity_apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 대외활동 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apply")
    @NotNull
    public Apply apply; // 이력서 고유값(Foreign key)

    @Column(name = "start")
    @NotNull
    public LocalDate start; // 대외활동 시작일

    @Column(name = "end")
    @NotNull
    public LocalDate end; // 대외활동 종료일

    @Column(length = 100, name = "title")
    @NotNull
    public String title; // 대외활동명

    @Column(length = 100, name = "holdby")
    @NotNull
    public String holdby; // 대외활동 주최단체

    @Column(length = 2000, name = "detail")
    public String detail; // 대외활동 상세활동내역

    public Activity_apply() {

    }

    public Activity_apply(@NotNull Apply apply, @NotNull LocalDate start, @NotNull LocalDate end, @NotNull String title,
            @NotNull String holdby, String detail) {

        this.apply = apply;
        this.start = start;
        this.end = end;
        this.title = title;
        this.holdby = holdby;
        this.detail = detail;
    }

}
