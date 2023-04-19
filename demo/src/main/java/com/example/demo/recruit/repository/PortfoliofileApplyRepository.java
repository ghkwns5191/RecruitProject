package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.PortfolioApply;
import com.example.demo.recruit.entity.PortfoliofileApply;

public interface PortfoliofileApplyRepository extends JpaRepository<PortfoliofileApply, Long> {

    PortfoliofileApply findByPortfolioApply(PortfolioApply portfolioApply);

}
