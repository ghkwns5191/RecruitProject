package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Portfoliofile;

public interface PortfoliofileRepository extends JpaRepository<Portfoliofile, Long> {
    Portfoliofile findByPortfolio(Portfolio portfolio);
}
