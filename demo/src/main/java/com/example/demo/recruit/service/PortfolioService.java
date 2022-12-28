package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.PortfolioDto;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.PortfolioRepository;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    
    // 해당 이력서의 포트폴리오 정보를 불러오는 코드
    public List<Portfolio> getPortfolio(Resume id_resume) {
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        portfolioRepository.findById_resume(id_resume).forEach(portfolio::add);
        return portfolio;
    }
    
    // 해당 포트폴리오 정보만 불러오는 코드
    public Portfolio getPortfolio(Long id_portfolio) {
        Optional<Portfolio> portfolioData = portfolioRepository.findById(id_portfolio);
        Portfolio portfolio = portfolioData.get();
        return portfolio;
    }
    
    // 입력받은 포트폴리오 정보를 DB 에 저장하는 코드
    public Portfolio inputData(PortfolioDto portfolioDto) {
        Portfolio portfolio = this.portfolioRepository.save(new Portfolio(
                portfolioDto.getId_resume(),
                portfolioDto.getPortfolio_title(),
                portfolioDto.getPortfolio_file1(),
                portfolioDto.getPortfolio_file2(),
                portfolioDto.getPortfolio_url1(),
                portfolioDto.getPortfolio_url2()));
        return portfolio;
    }
}
