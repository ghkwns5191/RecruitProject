package com.example.demo.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Portfoliofile;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.PortfolioService;
import com.example.demo.recruit.service.PortfoliofileService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/portfoliofile")
public class PortfoliofileController {
	
	@Autowired
	PortfoliofileService portfoliofileService;
	
	@Autowired
	ResumeService resumeService;
	
	@Autowired
	PortfolioService portfolioService;

	@GetMapping("/get/{id}")
	public ResponseEntity<List<Portfoliofile>> getportfoliofile(@PathVariable("id") Long id) {
		try {
			Resume resume = this.resumeService.getResume(id);
			List<Portfolio> portfolioList = this.portfolioService.getPortfolio(resume);
			List<Portfoliofile> portfoliofileList = this.portfoliofileService.getList(portfolioList);
			return new ResponseEntity<>(portfoliofileList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/download/{id}")
	public void downloadFile(@PathVariable("id") Long id, HttpServletResponse response) {
		Portfolio portfolio = this.portfolioService.getPortfolio(id);
		this.portfoliofileService.downloadFile(portfolio, response);

	}
}
