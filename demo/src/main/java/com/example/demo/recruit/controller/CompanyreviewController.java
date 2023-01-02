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

import com.example.demo.recruit.dto.CompanyreviewDto;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Companyreview;
import com.example.demo.recruit.service.CompanyreviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CompanyreviewController {

    @Autowired
    private final CompanyreviewService companyreviewService;
    
    // 해당 기업에 대한 기업리뷰를 모두 조회하기 위해 사용
    @GetMapping("/companyreview/list")
    public ResponseEntity<List<Companyreview>> getList(@RequestParam(required = false) Company company) {
        try {
            List<Companyreview> companyreview = new ArrayList<Companyreview>();
            companyreview = companyreviewService.getcompanyreview(company);
            return new ResponseEntity<>(companyreview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 해당 기업리뷰를 상세 확인하기 위해 사용
    @GetMapping("/companyreview/detail")
    public ResponseEntity<Companyreview> getcompanyreview(@RequestParam(required = false) Long id) {
        try {
            Companyreview companyreview = new Companyreview();
            companyreview = companyreviewService.getcompanyreview(id);
            return new ResponseEntity<>(companyreview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 기업리뷰를 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/companyreview/input")
    public ResponseEntity<Companyreview> inputData(@RequestBody CompanyreviewDto companyreviewDto) {
        try {
            Companyreview companyreview = companyreviewService.inputData(companyreviewDto);
            return new ResponseEntity<>(companyreview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 기업리뷰를 수정하기 위해 사용
    @PutMapping("/companyreview/revise")
    public ResponseEntity<Companyreview> reviseData(@PathVariable("id") Long id, CompanyreviewDto companyreviewDto) {
        try {
            Companyreview companyreview = companyreviewService.inputData(id, companyreviewDto);
            return new ResponseEntity<>(companyreview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 기업리뷰를 삭제하기 위해 사용
    @DeleteMapping("/companyreview/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            companyreviewService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
