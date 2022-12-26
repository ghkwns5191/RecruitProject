package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.service.CompanyService;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getList() {

       try {
            List<Company> companyList = new ArrayList<Company>();
            companyList = companyService.getcompany();
            return new ResponseEntity<>(companyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity<Company> getCompany(@RequestParam(required = false) Long id_company) {
       try {
            Company company = new Company();
            company = companyService.getcompany(id_company);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
