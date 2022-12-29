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

    // 전체 회사 리스트를 조회하는 코드
    public List<Company> getcompany() {
        List<Company> company = new ArrayList<Company>();
        companyRepository.findAll().forEach(company::add);
        return company;
    }
    
    // 해당 회사 정보만 조회하는 코드
    public Company getcompany(Long id_company) {
        Optional<Company> companyData = companyRepository.findById(id_company);
        Company company = companyData.get();
        return company;
    }
   
    // 회사 정보를 입력받아 DB 에 저장하는 코드
    public Company inputData(CompanyDto companyDto) {
        Company company = this.companyRepository.save(new Company(
                companyDto.getId_member(), 
                companyDto.getCompany_name(), 
                companyDto.getCompany_type(), 
                companyDto.getCompany_address(), 
                companyDto.getCompany_phone(), 
                companyDto.getCompany_pp20number(), 
                companyDto.getCompany_numberofstaff(), 
                LocalDate.now()));
        return company;
    }
    
    // DB 에 저장된 기업정보를 불러내어 수정 및 다시 저장하는 코드
    public Company inputData(Long id_company, CompanyDto companyDto) {
        Optional<Company> companyData = this.companyRepository.findById(id_company);
        Company company = companyData.get();
        company.setCompany_type(companyDto.getCompany_type());
        company.setCompany_address(companyDto.getCompany_address());
        company.setCompany_phone(companyDto.getCompany_phone());
        company.setCompany_pp20number(companyDto.getCompany_pp20number());
        company.setCompany_numberofstaff(companyDto.getCompany_numberofstaff());
        company.setCompany_modifydate(LocalDate.now());
        this.companyRepository.save(company);
        return company;
    }
    
    // DB 에 저장된 기업 정보를 삭제하는 코드
    public void deleteData(Long id_company) {
        this.companyRepository.deleteById(id_company);
    }
}
