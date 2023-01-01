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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyreviewService {

    @Autowired
    private final CompanyreviewRepository companyreviewRepository;
    
    @Autowired
    private final CompanyRepository companyRepository;

    // 해당 기업에 대한 기업리뷰를 조회하는 코드
    public List<Companyreview> getcompanyreview(Company company) {
        List<Companyreview> companyreview = new ArrayList<Companyreview>();
        this.companyreviewRepository.findByCompany(company).forEach(companyreview::add);
        return companyreview;
    }

    // 해당 기업리뷰만 조회하는 코드
    public Companyreview getcompanyreview(Long id) {
        Optional<Companyreview> companyreviewData = companyreviewRepository.findById(id);
        Companyreview companyreview = companyreviewData.get();
        return companyreview;
    }

    // 기업리뷰를 입력받아 DB 에 저장하는 코드
    public Companyreview inputData(CompanyreviewDto companyreviewDto) {
        Companyreview companyreview = this.companyreviewRepository.save(new Companyreview(
                companyreviewDto.getCompany(),
                companyreviewDto.getMember(),
                companyreviewDto.getStrength(),
                companyreviewDto.getWeakness(),
                companyreviewDto.getReviewdetail(),
                companyreviewDto.getScore()));
        return companyreview;
    }
    
    // DB 에 저장된 기업리뷰를 불러내어 수정하는 코드
    public Companyreview inputData(Long id, CompanyreviewDto companyreviewDto) {
        Optional<Companyreview> companyreviewData = this.companyreviewRepository.findById(id);
        Companyreview companyreview = companyreviewData.get();
        companyreview.setStrength(companyreviewDto.getStrength());
        companyreview.setWeakness(companyreviewDto.getWeakness());
        companyreview.setReviewdetail(companyreviewDto.getReviewdetail());
        companyreview.setScore(companyreviewDto.getScore());
        this.companyreviewRepository.save(companyreview);
        return companyreview;
    }
    
    // DB 에 저장된 기업리뷰를 삭제하는 코드
    public void deleteData(Long id) {
        this.companyreviewRepository.deleteById(id);
    }
    
    // 기업정보 삭제 시 사용할 코드
    public void deleteCompany(Long id) {
        Optional<Company> companyData = companyRepository.findById(id);
        Company company = companyData.get();
        List<Companyreview> companyreview = new ArrayList<Companyreview>();
        this.companyreviewRepository.findByCompany(company).forEach(companyreview::add);
        this.companyreviewRepository.deleteAll(companyreview);
    }
}
