package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Companyreview;

public interface CompanyreviewRepository extends JpaRepository<Companyreview, Long> {

    List<Companyreview> findById_company(Company id_company);

}
