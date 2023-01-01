package com.example.demo.recruit.entity;

import java.time.LocalDate;

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
@Table(name = "certificate")
@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 자격증 고유값

    @ManyToOne
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)

    @Column(name = "achievedate")
    @NotNull
    public LocalDate achievedate; // 자격증 취득일

    @Column(length = 100, name = "name")
    @NotNull
    public String name; // 자격증명

    @Column(length = 100, name = "grade")
    public String grade; // 자격증 등급 및 점수

    @Column(length = 100, name = "achievefrom")
    @NotNull
    public String achievefrom; // 자격증 발급처

    @Column(length = 100, name = "certificatenumber")
    @NotNull
    public String certificatenumber; // 자격증 번호

    public Certificate() {

    }

    public Certificate(@NotNull Resume resume, @NotNull LocalDate achievedate, @NotNull String name, String grade,
            @NotNull String achievefrom, @NotNull String certificatenumber) {

        this.resume = resume;
        this.achievedate = achievedate;
        this.name = name;
        this.grade = grade;
        this.achievefrom = achievefrom;
        this.certificatenumber = certificatenumber;
    }

}
