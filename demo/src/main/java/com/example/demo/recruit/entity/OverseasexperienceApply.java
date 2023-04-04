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
@Table(name = "overseasexperienceapply")
@Entity
public class OverseasexperienceApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id; // 해외경험 고유값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apply")
    @NotNull
    public Apply apply; // 이력서 고유값(Foreign key)

    @Column(name = "start")
    @NotNull
    public LocalDate start; // 해외경험 시작일

    @Column(name = "end")
    @NotNull
    public LocalDate end; // 해외경험 종료일

    @Column(length = 100, name = "staying")
    @NotNull
    public String staying; // 해외경험 체류중 여부

    @Column(length = 100, name = "country")
    @NotNull
    public String country; // 해외경험 국가명

    @Column(length = 2000, name = "detail")
    public String detail; // 해외경험 상세내용
    
    public OverseasexperienceApply() {
        // TODO Auto-generated constructor stub
    }

    public OverseasexperienceApply(@NotNull Apply apply, @NotNull LocalDate start, @NotNull LocalDate end,
            @NotNull String staying, @NotNull String country, String detail) {
        
        this.apply = apply;
        this.start = start;
        this.end = end;
        this.staying = staying;
        this.country = country;
        this.detail = detail;
    }
    
    
    
}
