package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Companyreview;
import com.example.demo.recruit.repository.CompanyreviewRepository;

@Service
public class CompanyreviewService {

    @Autowired
    private CompanyreviewRepository companyreviewRepository;
    
    public List<Companyreview> getcompanyreview(Company id_company) {
        List<Companyreview> companyreview = new ArrayList<Companyreview>();
        companyreviewRepository.findById_company(id_company).forEach(companyreview::add);
        return companyreview;
    }
    
    public Companyreview getcompanyreview(Long id_companyreview) {
        Optional<Companyreview> companyreviewData = companyreviewRepository.findById(id_companyreview);
        Companyreview companyreview = companyreviewData.get();
        return companyreview;
    }
}
