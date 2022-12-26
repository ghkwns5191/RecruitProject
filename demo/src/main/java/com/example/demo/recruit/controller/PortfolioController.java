package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.PortfolioService;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<Portfolio>> getList(@RequestParam(required = false) Resume id_resume) {
        try {
            List<Portfolio> portfolio = new ArrayList<Portfolio>();
            portfolio = portfolioService.getPortfolio(id_resume);
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @GetMapping
    public ResponseEntity<Portfolio> getPortfolio(@RequestParam(required = false) Long id_portfolio) {
        try {
            Portfolio portfolio = new Portfolio();
            portfolio = portfolioService.getPortfolio(id_portfolio);
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
