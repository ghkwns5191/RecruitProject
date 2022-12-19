package com.example.demo.recruit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificate")
    public Long id_certificate; // 자격증 고유값
    
    @JoinColumn(name = "id_resume")
    public Long id_resume; // 이력서 고유값(Foreign key)
    
    @Column(name = "certificate_achievedate")
    public LocalDate certificate_achievedate; // 자격증 취득일
    
    @Column(length = 100, name = "certificate_name")
    public String certificate_name; // 자격증명
    
    @Column(length = 100, name = "certificate_grade")
    public String certificate_grade; // 자격증 등급 및 점수
    
    @Column(length = 100, name = "certificate_achievefrom")
    public String certificate_achievefrom; // 자격증 발급처
    
    @Column(length = 100, name = "certificate_certificatenumber")
    public String certificate_certificatenumber; // 자격증 번호
    
    public Certificate() {
        
    }

    public Certificate(Long id_resume, LocalDate certificate_achievedate, String certificate_name,
            String certificate_grade, String certificate_achievefrom, String certificate_certificatenumber) {
       
        this.id_resume = id_resume;
        this.certificate_achievedate = certificate_achievedate;
        this.certificate_name = certificate_name;
        this.certificate_grade = certificate_grade;
        this.certificate_achievefrom = certificate_achievefrom;
        this.certificate_certificatenumber = certificate_certificatenumber;
    }
    
    
    
    
}
