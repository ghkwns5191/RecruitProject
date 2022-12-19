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
@Table(name = "recruit")
@Entity
public class Recruit {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recruit")
	public Long id_recruit; // 채용공고 고유값
    
    @ManyToOne
    @JoinColumn(name = "id_member")
    @NotNull
    public Member id_member; // 회원 고유값(Foreign key)
	
    @Column(length = 100, name = "recruit_title")
    @NotNull
	public String recruit_title;// 제목
	
    @Column(length = 100, name = "recruit_writer")
    @NotNull
	public String recruit_writer;// 작성자

    @Column(name = "recruit_registerdate")
    @NotNull
	public LocalDate recruit_registerdate;// 작성일
	
    @Column(name = "recruit_modifydate")
	public LocalDate recruit_modifydate;// 수정일 
	
	@Column(length = 100, name = "recruit_career")
	@NotNull
	public String recruit_career;// 경력여부
	
	@Column(length = 100, name = "recruit_salary")
	@NotNull
	public String recruit_salary;// 연봉 or 월급
	
	@Column(length = 100, name = "recruit_workingdays")
	@NotNull
	public String recruit_workingdays;// 근무일자 ==> 월~금, 월~토, 기타
	
	@Column(length = 3000, name = "recruit_detail")
	public String recruit_detail;// 상세내용
	
	@Column(length = 100, name = "recruit_phonenumber")
	@NotNull
	public String recruit_phonenumber; // 공고 연락처
	
    @Column(length = 100, name = "recruit_attn")
    @NotNull
    public String recruit_attn; // 채용공고 담당자
	
    public Recruit() {
        
    }

    public Recruit(Member id_member, String recruit_title, String recruit_writer, LocalDate recruit_registerdate,
            LocalDate recruit_modifydate, String recruit_career, String recruit_salary, String recruit_workingdays,
            String recruit_detail, String recruit_phonenumber, String recruit_attn) {
        super();
        this.id_member = id_member;
        this.recruit_title = recruit_title;
        this.recruit_writer = recruit_writer;
        this.recruit_registerdate = recruit_registerdate;
        this.recruit_modifydate = recruit_modifydate;
        this.recruit_career = recruit_career;
        this.recruit_salary = recruit_salary;
        this.recruit_workingdays = recruit_workingdays;
        this.recruit_detail = recruit_detail;
        this.recruit_phonenumber = recruit_phonenumber;
        this.recruit_attn = recruit_attn;
    }

    
    
    

	
	
}
