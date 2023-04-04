package com.example.demo.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.PortfolioApply;
import com.example.demo.recruit.repository.PortfolioApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioApplyService {

    @Autowired
    private final PortfolioApplyRepository portfolioApplyRepository;

    public void inputData(List<Portfolio> portfolioList, Apply apply) {
        for (int i = 0; i < portfolioList.size(); i++) {
            this.portfolioApplyRepository.save(new PortfolioApply(
                    apply,
                    portfolioList.get(i).getTitle(),
                    portfolioList.get(i).getUrl1(),
                    portfolioList.get(i).getUrl2()));
        }
    }
}
