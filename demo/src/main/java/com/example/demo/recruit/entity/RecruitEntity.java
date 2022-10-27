package com.example.demo.recruit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
public class RecruitEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id; // 고유 아이디값
	
    @Column(length = 100, name = "rtitle")
	public String rtitle;// 제목
	
    @Column(length = 100, name = "writer")
	public String writer;// 작성자

	public LocalDate registerDate;// 작성일
	
	public LocalDate modifyDate;// 수정일 
	
	@Column(length = 100, name = "career")
	public String career;// 경력여부
	
	@Column(length = 100, name = "salary")
	public Integer salary;// 연봉
	
	@Column(length = 100, name = "workingDays")
	public String workingDays;// 근무일자 ==> 월~금, 월~토, 기타
	
	@Column(length = 6500, name = "detail")
	public String detail;// 상세내용
	
	@Column(length = 1000, name = "messenger")
	public String messenger; // 카카오톡 or 라인 연락처
	
	@Column(length = 500, name = "homePage")
	public String homePage;
	
	@Column(length = 100, name = "phoneNumber")
	public String phoneNumber;
	
	// 
	
	public RecruitEntity() {
	    
	}

    public RecruitEntity(String rtitle, String writer, LocalDate registerDate, LocalDate modifyDate, String career,
            Integer salary, String workingDays, String detail, String messenger, String homePage, String phoneNumber) {
        super();
        this.rtitle = rtitle;
        this.writer = writer;
        this.registerDate = registerDate;
        this.modifyDate = modifyDate;
        this.career = career;
        this.salary = salary;
        this.workingDays = workingDays;
        this.detail = detail;
        this.messenger = messenger;
        this.homePage = homePage;
        this.phoneNumber = phoneNumber;
    }
	
	
}
