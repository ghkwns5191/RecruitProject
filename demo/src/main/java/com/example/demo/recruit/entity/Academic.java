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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "academic")
@Entity
public class Academic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 학력정보 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)

    @Column(name = "start")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate start;// 학력 시작일

    @Column(name = "end")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate end;// 학력 종료일

    @Column(length = 100, name = "studying")
    @NotNull
    public String studying;// 졸업 여부

    @Column(length = 100, name = "type")
    @NotNull
    public String type;// 구분 (고등학교, 대학교, 대학원)

    @Column(length = 100, name = "name")
    @NotNull
    public String name;// 학교명

    @Column(length = 100, name = "major")
    @NotNull
    public String major;// 전공

    @Column(length = 100, name = "grade")
    public String grade;// 학점

    @Column(length = 100, name = "gradefull")
    public String gradefull;// 학점 총점

    @Column(length = 1000, name = "detail")
    public String detail;// 학력 상세내용

    public Academic() {
        // TODO Auto-generated constructor stub
    }

    public Academic(@NotNull Resume resume, @NotNull LocalDate start, @NotNull LocalDate end, @NotNull String studying,
            @NotNull String type, @NotNull String name, @NotNull String major, String grade, String gradefull,
            String detail) {

        this.resume = resume;
        this.start = start;
        this.end = end;
        this.studying = studying;
        this.type = type;
        this.name = name;
        this.major = major;
        this.grade = grade;
        this.gradefull = gradefull;
        this.detail = detail;
    }

}
