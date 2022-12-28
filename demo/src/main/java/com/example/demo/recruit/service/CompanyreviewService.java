package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CompanyreviewDto;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Companyreview;
import com.example.demo.recruit.repository.CompanyreviewRepository;

@Service
public class CompanyreviewService {

    @Autowired
    private CompanyreviewRepository companyreviewRepository;

    // 해당 기업에 대한 기업리뷰를 조회하는 코드
    public List<Companyreview> getcompanyreview(Company id_company) {
        List<Companyreview> companyreview = new ArrayList<Companyreview>();
        companyreviewRepository.findById_company(id_company).forEach(companyreview::add);
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
}
