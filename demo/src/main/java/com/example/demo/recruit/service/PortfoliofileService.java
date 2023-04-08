package com.example.demo.recruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.repository.PortfoliofileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfoliofileService {

    @Autowired
    private final PortfoliofileRepository portfoliofileRepository;
    
    
}
