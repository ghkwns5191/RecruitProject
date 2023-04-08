package com.example.demo.recruit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.recruit.entity.Portfoliofile;

@Controller
@RequestMapping("/portfoliofile")
public class PortfoliofileController {
    
    
    @PostMapping("/new")
    public ResponseEntity<Portfoliofile> newfile() {
        
        
        return new ResponseEntity<>();
    }
}
