package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.PortfolioRepository;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    
    public List<Portfolio> getPortfolio(Resume id_resume) {
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        portfolioRepository.findById_resume(id_resume).forEach(portfolio::add);
        return portfolio;
    }
    
    public Portfolio getPortfolio(Long id_portfolio) {
        Optional<Portfolio> portfolioData = portfolioRepository.findById(id_portfolio);
        Portfolio portfolio = portfolioData.get();
        return portfolio;
    }
}
