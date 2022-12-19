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
@Table(name = "overseasexperience")
@Entity
public class Overseasexperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_overseasexperience")
    public Long id_overseasexperience; // 해외경험 고유값
    
    @ManyToOne
    @JoinColumn(name = "id_resume")
    @NotNull
    public Resume id_resume; // 이력서 고유값(Foreign key)
    
    @Column(name = "overseasexperience_start")
    @NotNull
    public LocalDate overseasexperience_start; // 해외경험 시작일
    
    @Column(name = "overseasexperience_end")
    @NotNull
    public LocalDate overseasexperience_end; // 해외경험 종료일
    
    @Column(length = 100, name = "overseasexperience_staying")
    @NotNull
    public String overseasexperience_staying; // 해외경험 체류중 여부
    
    @Column(length = 100, name = "overseasexperience_country")
    @NotNull
    public String overseasexperience_country; // 해외경험 국가명

    @Column(length = 2000, name = "overseasexperience_detail")
    public String overseasexperience_detail; // 해외경험 상세내용
    
    public Overseasexperience() {
        
    }

    public Overseasexperience(Resume id_resume, LocalDate overseasexperience_start, LocalDate overseasexperience_end,
            String overseasexperience_staying, String overseasexperience_country, String overseasexperience_detail) {
        
        this.id_resume = id_resume;
        this.overseasexperience_start = overseasexperience_start;
        this.overseasexperience_end = overseasexperience_end;
        this.overseasexperience_staying = overseasexperience_staying;
        this.overseasexperience_country = overseasexperience_country;
        this.overseasexperience_detail = overseasexperience_detail;
    }

    
    
    
}
