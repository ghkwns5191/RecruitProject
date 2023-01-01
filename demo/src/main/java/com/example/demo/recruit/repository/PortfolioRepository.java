package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    List<Portfolio> findByResume(Resume resume);

}
