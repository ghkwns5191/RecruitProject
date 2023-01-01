package com.example.demo.recruit.entity;

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
@Table(name = "portfolio")
@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 포트폴리오 고유값

    @ManyToOne
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)

    @Column(length = 200, name = "title")
    @NotNull
    public String title; // 포트폴리오 제목

    @Column(length = 2000, name = "file1")
    public String file1; // 포트폴리오 파일1

    @Column(length = 2000, name = "file2")
    public String file2; // 포트폴리오 파일2

    @Column(length = 200, name = "url1")
    public String url1; // 포트폴리오 링크1

    @Column(length = 200, name = "url2")
    public String url2; // 포트폴리오 링크2

    public Portfolio() {

    }

    public Portfolio(@NotNull Resume resume, @NotNull String title, String file1, String file2, String url1,
            String url2) {

        this.resume = resume;
        this.title = title;
        this.file1 = file1;
        this.file2 = file2;
        this.url1 = url1;
        this.url2 = url2;
    }

}
