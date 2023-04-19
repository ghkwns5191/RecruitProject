package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.PortfolioApply;
import com.example.demo.recruit.entity.Portfoliofile;
import com.example.demo.recruit.entity.PortfoliofileApply;
import com.example.demo.recruit.repository.PortfoliofileApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfoliofileApplyService {

    @Autowired
    private final PortfoliofileApplyRepository portfoliofileApplyRepository;

    public List<PortfoliofileApply> getList(List<PortfolioApply> portfolioApplyList) {
        List<PortfoliofileApply> portfoliofileApplyList = new ArrayList<>();        
        for (int i = 0; i < portfolioApplyList.size(); i++) {
            PortfoliofileApply portfoliofileApply = this.portfoliofileApplyRepository
                    .findByPortfolioApply(portfolioApplyList.get(i));
            if (portfoliofileApply != null) {
                portfoliofileApplyList.set(i, portfoliofileApply);
            } else {
                portfoliofileApplyList.set(i, null);
            }

        }
        return portfoliofileApplyList;
    }

    public PortfoliofileApply inputData(Portfoliofile portfoliofile, PortfolioApply portfolioApply) {
        PortfoliofileApply portfoliofileApply = this.portfoliofileApplyRepository.save(new PortfoliofileApply(
                portfoliofile.getFilename(),
                portfoliofile.getOriname(),
                portfoliofile.getFileurl(),
                portfolioApply));

        return portfoliofileApply;
    }
}
