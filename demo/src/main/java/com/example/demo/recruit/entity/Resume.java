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
    @Column(name = "id")
    public Long id; // 이력서 고유값

    @OneToOne
    @JoinColumn(name = "member")
    @NotNull
    public Member member; // 회원 고유값(Foreign key)

    @Column(length = 4000, name = "cv")
    public String cv;// 이력서 자기소개서

    @Column(length = 4000, name = "openforheadhunter")
    @NotNull
    public String openforheadhunter;// 이력서 공개여부

    public Resume() {

    }

    public Resume(@NotNull Member member, String cv, @NotNull String openforheadhunter) {

        this.member = member;
        this.cv = cv;
        this.openforheadhunter = openforheadhunter;
    }

}
