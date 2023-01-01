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
    @Column(name = "id_certificate")
    public Long id_certificate; // 자격증 고유값
    
    @ManyToOne
    @JoinColumn(name = "resume")
    @NotNull
    public Resume resume; // 이력서 고유값(Foreign key)
    
    @Column(name = "certificate_achievedate")
    @NotNull
    public LocalDate certificate_achievedate; // 자격증 취득일
    
    @Column(length = 100, name = "certificate_name")
    @NotNull
    public String certificate_name; // 자격증명
    
    @Column(length = 100, name = "certificate_grade")
    public String certificate_grade; // 자격증 등급 및 점수
    
    @Column(length = 100, name = "certificate_achievefrom")
    @NotNull
    public String certificate_achievefrom; // 자격증 발급처
    
    @Column(length = 100, name = "certificate_certificatenumber")
    @NotNull
    public String certificate_certificatenumber; // 자격증 번호
    
    public Certificate() {
        
    }

    public Certificate(Resume resume, LocalDate certificate_achievedate, String certificate_name,
            String certificate_grade, String certificate_achievefrom, String certificate_certificatenumber) {
        
        this.resume = resume;
        this.certificate_achievedate = certificate_achievedate;
        this.certificate_name = certificate_name;
        this.certificate_grade = certificate_grade;
        this.certificate_achievefrom = certificate_achievefrom;
        this.certificate_certificatenumber = certificate_certificatenumber;
    }

    
    
    
    
    
}
