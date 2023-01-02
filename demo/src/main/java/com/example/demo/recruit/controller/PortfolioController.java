package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.PortfolioDto;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.PortfolioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PortfolioController {

    @Autowired
    private final PortfolioService portfolioService;

    // 해당 이력서 조회 시 포트폴리오 내용 함께 조회하기 위해 사용
    @GetMapping("/portfolio/list")
    public ResponseEntity<List<Portfolio>> getList(@RequestParam(required = false) Resume resume) {
        try {
            List<Portfolio> portfolio = new ArrayList<Portfolio>();
            portfolio = portfolioService.getPortfolio(resume);
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 해당 포트폴리오 내역만 조회하기 위해 사용
    @GetMapping("/portfolio/detail")
    public ResponseEntity<Portfolio> getPortfolio(@RequestParam(required = false) Long id) {
        try {
            Portfolio portfolio = new Portfolio();
            portfolio = portfolioService.getPortfolio(id);
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 포트폴리오 내용을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/portfolio/input")
    public ResponseEntity<Portfolio> inputData(@RequestBody PortfolioDto portfolioDto) {
        try {
            Portfolio portfolio = portfolioService.inputData(portfolioDto);
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 포트폴리오 내역을 수정하기 위해 사용
    @PutMapping("/portfolio/revise")
    public ResponseEntity<Portfolio> reviseData(@PathVariable("id") Long id, @RequestBody PortfolioDto portfolioDto) {
        try {
            Portfolio portfolio = portfolioService.inputData(id, portfolioDto);
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 포트폴리오 내역을 삭제하기 위해 사용
    @DeleteMapping("/portfolio/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            portfolioService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
