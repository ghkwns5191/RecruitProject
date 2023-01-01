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
@Table(name = "languages")
@Entity
public class Languages {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_languages")
    public Long id_languages; // 어학 고유값
    
    @ManyToOne
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)
    
    @Column(length = 100, name = "languages_leveltalking")
    @NotNull
    public String languages_leveltalking; // 어학 회화능력
    
    @Column(length = 100, name = "languages_levelwriting")
    @NotNull
    public String languages_levelwriting; // 어학 작문독해능력
    
    @Column(length = 100, name = "languages_test")
    public String languages_test; // 어학 시험명
    
    @Column(length = 100, name = "languages_score")
    public String languages_score; // 어학 시험점수 및 등급
    
    @Column(name = "languages_achievedate")
    public LocalDate languages_achievedate; // 어학 시험점수 취득일
    
    @Column(length = 100, name = "languages_certificatenumber")
    public String languages_certificatenumber; // 어학 시험성적표 번호
    
    public Languages() {
        
    }

    public Languages(Resume resume, String languages_leveltalking, String languages_levelwriting,
            String languages_test, String languages_score, LocalDate languages_achievedate,
            String languages_certificatenumber) {
       
        this.resume = resume;
        this.languages_leveltalking = languages_leveltalking;
        this.languages_levelwriting = languages_levelwriting;
        this.languages_test = languages_test;
        this.languages_score = languages_score;
        this.languages_achievedate = languages_achievedate;
        this.languages_certificatenumber = languages_certificatenumber;
    }

    
    
    
}
