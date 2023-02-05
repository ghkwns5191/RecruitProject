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
@Table(name = "languages")
@Entity
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 어학 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)
    
    @Column(length = 100, name = "languages")
    @NotNull
    public String languages; // 언어 명
    
    @Column(length = 100, name = "leveltalking")
    @NotNull
    public String leveltalking; // 어학 회화능력

    @Column(length = 100, name = "levelwriting")
    @NotNull
    public String levelwriting; // 어학 작문독해능력

    @Column(length = 100, name = "test")
    public String test; // 어학 시험명

    @Column(length = 100, name = "score")
    public String score; // 어학 시험점수 및 등급

    @Column(name = "achievedate")
    public LocalDate achievedate; // 어학 시험점수 취득일

    @Column(length = 100, name = "certificatenumber")
    public String certificatenumber; // 어학 시험성적표 번호

    public Languages() {

    }

    public Languages(@NotNull Resume resume, @NotNull String languages, @NotNull String leveltalking, @NotNull String levelwriting, String test,
            String score, LocalDate achievedate, String certificatenumber) {

        this.resume = resume;
        this.languages = languages;
        this.leveltalking = leveltalking;
        this.levelwriting = levelwriting;
        this.test = test;
        this.score = score;
        this.achievedate = achievedate;
        this.certificatenumber = certificatenumber;
    }

}
