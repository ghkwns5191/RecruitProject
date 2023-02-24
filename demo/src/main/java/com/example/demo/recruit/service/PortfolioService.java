package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.PortfolioDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.PortfolioRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    @Autowired
    private final PortfolioRepository portfolioRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 해당 이력서의 포트폴리오 정보를 불러오는 코드
    public List<Portfolio> getPortfolio(Resume resume) {
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        portfolioRepository.findByResume(resume).forEach(portfolio::add);
        return portfolio;
    }

    // 해당 포트폴리오 정보만 불러오는 코드
    public Portfolio getPortfolio(Long id) {
        Optional<Portfolio> portfolioData = portfolioRepository.findById(id);
        Portfolio portfolio = portfolioData.get();
        return portfolio;
    }

    // 입력받은 포트폴리오 정보를 DB 에 저장하는 코드
    public List<Portfolio> inputData(List<PortfolioDto> portfolioDtoList, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Portfolio> portfolioList = new ArrayList<>();
        for (int i = 0; i < portfolioDtoList.size(); i++) {
            PortfolioDto portfolioDto = portfolioDtoList.get(i);
            Portfolio portfolio = this.portfolioRepository.save(new Portfolio(
                    resume,
                    portfolioDto.getTitle(),
                    portfolioDto.getUrl1(),
                    portfolioDto.getUrl2()));
            portfolioList.add(portfolio);
        }
        return portfolioList;
    }

    // DB 에 저장된 포트폴리오 내역을 수정하는 코드
    public Portfolio inputData(Long id, PortfolioDto portfolioDto) {
        Optional<Portfolio> portfolioData = this.portfolioRepository.findById(id);
        Portfolio portfolio = portfolioData.get();
        portfolio.setTitle(portfolioDto.getTitle());
        portfolio.setUrl1(portfolioDto.getUrl1());
        portfolio.setUrl2(portfolioDto.getUrl2());
        this.portfolioRepository.save(portfolio);
        return portfolio;
    }

    // DB 에 저장된 포트폴리오 내역을 삭제하는 코드
    public void deleteData(Long id) {
        this.portfolioRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        this.portfolioRepository.findByResume(resume).forEach(portfolio::add);
        this.portfolioRepository.deleteAll(portfolio);
    }
}
