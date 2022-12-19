package com.example.demo.recruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "resume")
@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resume")
    public Long id_resume; // 이력서 고유값
    
    @OneToOne
    @JoinColumn(name = "id_member")
    @NotNull
    public Member id_member; // 회원 고유값(Foreign key)
    
    @Column(length = 3000, name = "resume_photo")
    @NotNull
    public String resume_photo;// 이력서 사진
    
    @Column(length = 4000, name = "resume_cv")
    public String resume_cv;// 이력서 자기소개서
    
    @Column(length = 4000, name = "resume_openforheadhunter")
    @NotNull
    public String resume_openforheadhunter;// 이력서 공개여부
    
    public Resume() {
        
    }

    public Resume(Member id_member, String resume_photo, String resume_cv, String resume_openforheadhunter) {
        super();
        this.id_member = id_member;
        this.resume_photo = resume_photo;
        this.resume_cv = resume_cv;
        this.resume_openforheadhunter = resume_openforheadhunter;
    }

    
    
    
}
