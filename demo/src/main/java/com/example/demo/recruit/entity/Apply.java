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
@Table(name = "apply")
@Entity
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apply")
    public Long id_apply; // 지원 고유값
    
    @ManyToOne
    @JoinColumn(name = "member")
    @NotNull
    public Member member; // 회원 고유값(Foreign key)
    
    @ManyToOne
    @JoinColumn(name = "recruit")
    @NotNull
    public Recruit recruit; // 채용공고 고유값(Foreign key)
    
    @Column(name = "apply_applydate")
    public LocalDate apply_applydate; // 지원날짜
    
    public Apply() {
        
    }

    public Apply(@NotNull Member member, @NotNull Recruit recruit, LocalDate apply_applydate) {
        
        this.member = member;
        this.recruit = recruit;
        this.apply_applydate = apply_applydate;
    }

    

    
    
    
}
