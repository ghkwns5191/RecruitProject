package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Member;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByMember(Member member);

}
