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
@Table(name = "recruit")
@Entity
public class Recruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 채용공고 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    @NotNull
    public Member member; // 회원 고유값(Foreign key)

    @Column(length = 100, name = "title")
    @NotNull
    public String title;// 제목

    @Column(length = 100, name = "writer")
    @NotNull
    public String writer;// 작성자

    @Column(name = "registerdate")
    @NotNull
    public LocalDate registerdate;// 작성일

    @Column(name = "modifydate")
    public LocalDate modifydate;// 수정일

    @Column(length = 100, name = "career")
    @NotNull
    public String career;// 경력여부

    @Column(length = 100, name = "salary")
    @NotNull
    public String salary;// 연봉 or 월급

    @Column(length = 100, name = "workingdays")
    @NotNull
    public String workingdays;// 근무일자 ==> 월~금, 월~토, 기타

    @Column(length = 3000, name = "detail")
    public String detail;// 상세내용

    @Column(length = 100, name = "phonenumber")
    @NotNull
    public String phonenumber; // 공고 연락처

    @Column(length = 100, name = "attn")
    @NotNull
    public String attn; // 채용공고 담당자

    public Recruit() {

    }

    public Recruit(@NotNull Member member, @NotNull String title, @NotNull String writer,
            @NotNull LocalDate registerdate, LocalDate modifydate, @NotNull String career, @NotNull String salary,
            @NotNull String workingdays, String detail, @NotNull String phonenumber, @NotNull String attn) {

        this.member = member;
        this.title = title;
        this.writer = writer;
        this.registerdate = registerdate;
        this.modifydate = modifydate;
        this.career = career;
        this.salary = salary;
        this.workingdays = workingdays;
        this.detail = detail;
        this.phonenumber = phonenumber;
        this.attn = attn;
    }

}
