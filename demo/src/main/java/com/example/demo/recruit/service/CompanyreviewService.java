package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CompanyreviewDto;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Companyreview;
import com.example.demo.recruit.repository.CompanyRepository;
import com.example.demo.recruit.repository.CompanyreviewRepository;

@Service
public class CompanyreviewService {

    @Autowired
    private CompanyreviewRepository companyreviewRepository;
    
    @Autowired
    private CompanyRepository companyRepository;

    // 해당 기업에 대한 기업리뷰를 조회하는 코드
    public List<Companyreview> getcompanyreview(Company id_company) {
        List<Companyreview> companyreview = new ArrayList<Companyreview>();
        this.companyreviewRepository.findById_company(id_company).forEach(companyreview::add);
        return companyreview;
    }

    // 해당 기업리뷰만 조회하는 코드
    public Companyreview getcompanyreview(Long id_companyreview) {
        Optional<Companyreview> companyreviewData = companyreviewRepository.findById(id_companyreview);
        Companyreview companyreview = companyreviewData.get();
        return companyreview;
    }

    // 기업리뷰를 입력받아 DB 에 저장하는 코드
    public Companyreview inputData(CompanyreviewDto companyreviewDto) {
        Companyreview companyreview = this.companyreviewRepository.save(new Companyreview(
                companyreviewDto.getId_company(),
                companyreviewDto.getId_member(),
                companyreviewDto.getCompanyreview_strength(),
                companyreviewDto.getCompanyreview_weakness(),
                companyreviewDto.getCompanyreview_reviewdetail(),
                companyreviewDto.getCompanyreview_score()));
        return companyreview;
    }
    
    // DB 에 저장된 기업리뷰를 불러내어 수정하는 코드
    public Companyreview inputData(Long id_companyreview, CompanyreviewDto companyreviewDto) {
        Optional<Companyreview> companyreviewData = this.companyreviewRepository.findById(id_companyreview);
        Companyreview companyreview = companyreviewData.get();
        companyreview.setCompanyreview_strength(companyreviewDto.getCompanyreview_strength());
        companyreview.setCompanyreview_weakness(companyreviewDto.getCompanyreview_weakness());
        companyreview.setCompanyreview_reviewdetail(companyreviewDto.getCompanyreview_reviewdetail());
        companyreview.setCompanyreview_score(companyreviewDto.getCompanyreview_score());
        this.companyreviewRepository.save(companyreview);
        return companyreview;
    }
    
    // DB 에 저장된 기업리뷰를 삭제하는 코드
    public void deleteData(Long id_companyreview) {
        this.companyreviewRepository.deleteById(id_companyreview);
    }
    
    // 기업정보 삭제 시 사용할 코드
    public void deleteCompany(Long id_company) {
        Optional<Company> companyData = companyRepository.findById(id_company);
        Company company = companyData.get();
        List<Companyreview> companyreview = new ArrayList<Companyreview>();
        this.companyreviewRepository.findById_company(company).forEach(companyreview::add);
        this.companyreviewRepository.deleteAll(companyreview);
    }
}
