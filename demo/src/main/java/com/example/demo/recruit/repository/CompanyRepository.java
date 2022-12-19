package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
