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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.CompanyDto;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.service.CompanyService;
import com.example.demo.recruit.service.CompanyreviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    @Autowired
    private final CompanyreviewService companyreviewService;

    // 모든 기업 리스트를 조회하기 위해 사용
    @GetMapping("/list")
    public ResponseEntity<List<Company>> getList() {

        try {
            List<Company> companyList = new ArrayList<Company>();
            companyList = companyService.getcompany();
            return new ResponseEntity<>(companyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 해당 기업의 정보를 조회하기 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Company> getCompany(@RequestParam(required = false) Long id) {
        try {
            Company company = new Company();
            company = companyService.getcompany(id);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 기업정보를 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<Company> inputData(@RequestBody CompanyDto companyDto, Principal principal) {
        try {
            Company company = companyService.inputData(companyDto, principal);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 기업정보를 수정하기 위해 사용
    @PutMapping("/revise")
    public ResponseEntity<Company> reviseData(@PathVariable("id") Long id, CompanyDto companyDto) {
        try {
            Company company = companyService.inputData(id, companyDto);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 기업정보를 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            companyreviewService.deleteCompany(id);
            companyService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
