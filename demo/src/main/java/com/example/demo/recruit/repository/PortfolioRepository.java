package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
