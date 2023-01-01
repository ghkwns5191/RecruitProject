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
@Table(name = "career")
@Entity
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 경력사항 고유값

    @ManyToOne
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)

    @Column(name = "start")
    @NotNull
    public LocalDate start;// 경력 시작일

    @Column(name = "end")
    @NotNull
    public LocalDate end;// 경력 종료일

    @Column(length = 100, name = "working")
    @NotNull
    public String working;// 재직중 여부 (재직중 or 퇴사)

    @Column(length = 100, name = "companyname")
    @NotNull
    public String companyname;// 회사 이름

    @Column(length = 100, name = "rank")
    @NotNull
    public String rank;// 근무 직급

    @Column(length = 100, name = "salary")
    @NotNull
    public String salary;// 연봉/월급정보

    @Column(length = 100, name = "jobduty")
    @NotNull
    public String jobduty;// 직무부서

    @Column(length = 2000, name = "detail")
    public String detail;// 경력 상세내용

    public Career() {

    }

    public Career(@NotNull Resume resume, @NotNull LocalDate start, @NotNull LocalDate end, @NotNull String working,
            @NotNull String companyname, @NotNull String rank, @NotNull String salary, @NotNull String jobduty,
            String detail) {

        this.resume = resume;
        this.start = start;
        this.end = end;
        this.working = working;
        this.companyname = companyname;
        this.rank = rank;
        this.salary = salary;
        this.jobduty = jobduty;
        this.detail = detail;
    }

}
