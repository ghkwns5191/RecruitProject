package com.example.demo.recruit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CompanyDto;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getcompany() {
        List<Company> company = new ArrayList<Company>();
        companyRepository.findAll().forEach(company::add);
        return company;
    }
    
    public Company getcompany(Long id_company) {
        Optional<Company> companyData = companyRepository.findById(id_company);
        Company company = companyData.get();
        return company;
    }
   
    public Company inputData(CompanyDto companyDto) {
        Company company = this.companyRepository.save(new Company(companyDto.getId_member(), companyDto.getCompany_name(), companyDto.getCompany_type(), companyDto.getCompany_address(), companyDto.getCompany_phone(), companyDto.getCompany_pp20number(), companyDto.getCompany_numberofstaff(), LocalDate.now()));
        return company;
    }
}
