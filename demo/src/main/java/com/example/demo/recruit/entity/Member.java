package com.example.demo.recruit.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "member",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "member_username"),
                @UniqueConstraint(columnNames = "member_phone"),
                @UniqueConstraint(columnNames = "member_email")
        })
@Entity
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_member")
    public Long id_member; // 회원 고유값(Primary key)
    
    @Column(length = 100, name = "member_sort")
    @NotNull
    public String member_sort; // 회원 종류 (개인 or 기업)
    
    @Column(length = 100, name = "member_username")
    @NotNull
    public String member_username; // 회원 사용자명 (회원 기준 ID)
    
    @Column(length = 100, name = "member_password")
    @NotNull
    public String member_password; // 회원 비밀번호
    
    @Column(length = 100, name = "member_name")
    @NotNull
    public String member_name; // 회원 성명
    
    @Column(length = 100, name = "member_phone")
    public String member_phone; // 회원 연락처
    
    @Column(length = 100, name = "member_email")
    public String member_email; // 회원 이메일
    
    @Column(name = "member_birthday")
    public LocalDate member_birthday; // 회원 생년월일
    
    @Column(length = 500, name = "member_address")
    public String member_address; // 회원 주소
    
    @Column(name = "member_registerdate")
    public LocalDate member_registerdate; // 회원 가입일
    
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "member_role" ,
            joinColumns = @JoinColumn(name = "id_member"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> member_role = new HashSet<>(); // 회원 자격(사용자 or 관리자)
    
    public Member() {
        
    }

    public Member(Long id_member, @NotNull String member_sort, @NotNull String member_username,
            @NotNull String member_password, @NotNull String member_name, String member_phone, String member_email,
            LocalDate member_birthday, String member_address, LocalDate member_registerdate) {
        super();
        this.id_member = id_member;
        this.member_sort = member_sort;
        this.member_username = member_username;
        this.member_password = member_password;
        this.member_name = member_name;
        this.member_phone = member_phone;
        this.member_email = member_email;
        this.member_birthday = member_birthday;
        this.member_address = member_address;
        this.member_registerdate = member_registerdate;
    }

   
    
    
    
}
