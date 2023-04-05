package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.PortfolioApply;

public interface PortfolioApplyRepository extends JpaRepository<PortfolioApply, Long> {

    List<PortfolioApply> findAllByApply(Apply apply);
    
    void deleteAllByApply(Apply apply);

}
