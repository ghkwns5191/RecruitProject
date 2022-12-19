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
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apply")
    public Long id_apply; // 지원 고유값
    
    @JoinColumn(name = "id_member")
    public Long id_member; // 회원 고유값(Foreign key)
    
    @JoinColumn(name = "id_recruit")
    public Long id_recruit; // 채용공고 고유값(Foreign key)
    
    @Column(name = "apply_applydate")
    public LocalDate apply_applydate; // 지원날짜
    
    public Apply() {
        
    }

    public Apply(Long id_member, Long id_recruit, LocalDate apply_applydate) {
        
        this.id_member = id_member;
        this.id_recruit = id_recruit;
        this.apply_applydate = apply_applydate;
    }
    
    
}
