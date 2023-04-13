package com.example.demo.recruit.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.PortfolioService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    @Autowired
    private final PortfolioService portfolioService;
    
    @Autowired
    private final ResumeService resumeService;

    // 해당 이력서 조회 시 포트폴리오 내용 함께 조회하기 위해 사용
    @GetMapping("/list")
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
    @GetMapping("/detail")
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
    @PostMapping("/input")
    public ResponseEntity<List<Portfolio>> inputData(
            @RequestParam("portfoliofile") List<MultipartFile> portfoliofileList,
            @RequestParam("title") List<String> titleList,
            @RequestParam("url1") List<String> url1List,
            @RequestParam("url2") List<String> url2List,
            Principal principal) {
        try {
            List<Portfolio> portfolioList = portfolioService.inputData(titleList, url1List, url2List, portfoliofileList,
                    principal);
            return new ResponseEntity<>(portfolioList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 포트폴리오 내역을 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<List<Portfolio>> reviseData(@PathVariable("id") Long id,
            @RequestParam("portfoliofile") List<MultipartFile> portfoliofileList,
            @RequestParam("title") List<String> titleList, 
            @RequestParam("url1") List<String> url1List,
            @RequestParam("url2") List<String> url2List) {
        try {
            Resume resume = this.resumeService.getResume(id);
            List<Portfolio> portfolio = portfolioService.inputData(resume, portfoliofileList, titleList, url1List, url2List);
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 포트폴리오 내역을 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            portfolioService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
