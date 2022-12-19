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
public class Recruit {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recruit")
	public Long id_recruit; // 채용공고 고유값
    
    @JoinColumn(name = "id_member")
    public Long id_member; // 회원 고유값(Foreign key)
	
    @Column(length = 100, name = "recruit_title")
	public String recruit_title;// 제목
	
    @Column(length = 100, name = "recruit_writer")
	public String recruit_writer;// 작성자

    @Column(name = "recruit_registerdate")
	public LocalDate recruit_registerdate;// 작성일
	
    @Column(name = "recruit_modifydate")
	public LocalDate recruit_modifydate;// 수정일 
	
	@Column(length = 100, name = "recruit_career")
	public String recruit_career;// 경력여부
	
	@Column(length = 100, name = "recruit_salary")
	public String recruit_salary;// 연봉 or 월급
	
	@Column(length = 100, name = "recruit_workingdays")
	public String recruit_workingdays;// 근무일자 ==> 월~금, 월~토, 기타
	
	@Column(length = 3000, name = "recruit_detail")
	public String recruit_detail;// 상세내용
	
	@Column(length = 100, name = "recruit_phonenumber")
	public String recruit_phonenumber; // 공고 연락처
	
    @Column(length = 100, name = "recruit_attn")
    public String recruit_attn; // 채용공고 담당자
	
	// 
	

	
	
}
