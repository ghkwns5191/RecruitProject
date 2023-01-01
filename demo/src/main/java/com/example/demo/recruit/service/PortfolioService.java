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
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;
    
    // 해당 이력서의 포트폴리오 정보를 불러오는 코드
    public List<Portfolio> getPortfolio(Resume resume) {
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        portfolioRepository.findByResume(resume).forEach(portfolio::add);
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
                portfolioDto.getResume(),
                portfolioDto.getPortfolio_title(),
                portfolioDto.getPortfolio_file1(),
                portfolioDto.getPortfolio_file2(),
                portfolioDto.getPortfolio_url1(),
                portfolioDto.getPortfolio_url2()));
        return portfolio;
    }
    
    // DB 에 저장된 포트폴리오 내역을 수정하는 코드
    public Portfolio inputData(Long id_portfolio, PortfolioDto portfolioDto) {
        Optional<Portfolio> portfolioData = this.portfolioRepository.findById(id_portfolio);
        Portfolio portfolio = portfolioData.get();
        portfolio.setPortfolio_title(portfolioDto.getPortfolio_title());
        portfolio.setPortfolio_file1(portfolioDto.getPortfolio_file1());
        portfolio.setPortfolio_file2(portfolioDto.getPortfolio_file2());
        portfolio.setPortfolio_url1(portfolioDto.getPortfolio_url1());
        portfolio.setPortfolio_url2(portfolioDto.getPortfolio_url2());
        this.portfolioRepository.save(portfolio);
        return portfolio;
    }
    
    // DB 에 저장된 포트폴리오 내역을 삭제하는 코드
    public void deleteData(Long id_portfolio) {
        this.portfolioRepository.deleteById(id_portfolio);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        this.portfolioRepository.findByResume(resume).forEach(portfolio::add);
        this.portfolioRepository.deleteAll(portfolio);
    }
}
