package com.example.demo.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.PortfolioApply;
import com.example.demo.recruit.entity.Portfoliofile;
import com.example.demo.recruit.repository.PortfolioApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioApplyService {

    @Autowired
    private final PortfolioApplyRepository portfolioApplyRepository;
    
    @Autowired
    private final PortfoliofileService portfoliofileService;
    
    @Autowired
    private final PortfoliofileApplyService portfoliofileApplyService;

    public void inputData(List<Portfolio> portfolioList, Apply apply) {
        
        for (int i = 0; i < portfolioList.size(); i++) {           
            PortfolioApply portfolioApply = this.portfolioApplyRepository.save(new PortfolioApply(
                    apply,
                    portfolioList.get(i).getTitle(),
                    portfolioList.get(i).getUrl1(),
                    portfolioList.get(i).getUrl2()));
            
            Portfoliofile portfoliofile = this.portfoliofileService.getfile(portfolioList.get(i));
            this.portfoliofileApplyService.inputData(portfoliofile, portfolioApply);
        }
    }

    public List<PortfolioApply> getList(Apply apply) {
        List<PortfolioApply> portfolioApplyList = this.portfolioApplyRepository.findAllByApply(apply);
        return portfolioApplyList;
    }

    public void deleteList(Apply apply) {
        this.portfolioApplyRepository.deleteAllByApply(apply);
    }

}
