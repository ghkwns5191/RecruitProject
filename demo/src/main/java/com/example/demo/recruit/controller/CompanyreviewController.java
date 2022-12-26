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
import com.example.demo.recruit.entity.Companyreview;
import com.example.demo.recruit.service.CompanyreviewService;

@Controller
public class CompanyreviewController {

    @Autowired
    private CompanyreviewService companyreviewService;
    
    @GetMapping
    public ResponseEntity<List<Companyreview>> getList(@RequestParam(required = false) Company id_company) {
        try {
            List<Companyreview> companyreview = new ArrayList<Companyreview>();
            companyreview = companyreviewService.getcompanyreview(id_company);
            return new ResponseEntity<>(companyreview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<Companyreview> getcompanyreview(@RequestParam(required = false) Long id_companyreview) {
        try {
            Companyreview companyreview = new Companyreview();
            companyreview = companyreviewService.getcompanyreview(id_companyreview);
            return new ResponseEntity<>(companyreview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
