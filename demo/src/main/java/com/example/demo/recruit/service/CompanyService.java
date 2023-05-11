package com.example.demo.recruit.service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CompanyDto;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.repository.CompanyRepository;
import com.example.demo.recruit.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    private final MemberRepository memberRepository;
    
    @Autowired
    private final MemberService memberService;

    // 전체 회사 리스트를 조회하는 코드
    public List<Company> getcompany() {
        List<Company> company = new ArrayList<Company>();
        companyRepository.findAll().forEach(company::add);
        return company;
    }

    // 해당 회사 정보만 조회하는 코드
    public Company getcompany(Long id) {
        Optional<Company> companyData = companyRepository.findById(id);
        Company company = companyData.get();
        return company;
    }

    // 회사 정보를 입력받아 DB 에 저장하는 코드
    public Company inputData(CompanyDto companyDto, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Company company = this.companyRepository.save(new Company(
                member,
                companyDto.getName(),
                companyDto.getType(),
                companyDto.getAddress(),
                companyDto.getPhone(),
                companyDto.getPp20number(),
                companyDto.getNumberofstaff(),
                LocalDate.now()));
        return company;
    }

    // DB 에 저장된 기업정보를 불러내어 수정 및 다시 저장하는 코드
    public Company inputData(Long id, CompanyDto companyDto) {
        Optional<Company> companyData = this.companyRepository.findById(id);
        Company company = companyData.get();
        company.setType(companyDto.getType());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setPp20number(companyDto.getPp20number());
        company.setNumberofstaff(companyDto.getNumberofstaff());
        company.setModifydate(LocalDate.now());
        this.companyRepository.save(company);
        return company;
    }

    // DB 에 저장된 기업 정보를 삭제하는 코드
    public void deleteData(Long id) {
        this.companyRepository.deleteById(id);
    }

    public Company getData(Member member) {
        Company company = this.companyRepository.findByMember(member);
        return company;
    }
    
    public List<Company> getData(List<Member> memberList) {
        List<Company> companyList = new ArrayList<>();
        for (int i = 0; i < memberList.size(); i++) {
            Company company = getData(memberList.get(i));
            companyList.add(company);
        }
        return companyList;
    }
    
    public List<Company> getList(List<Recruit> recruitList) {
    	List<Company> companyList = new ArrayList<>();
    	for (int i = 0; i < recruitList.size(); i++) {
    		Member member = this.memberService.getMemberdata(recruitList.get(i));
    		Company company = getData(member);
    		companyList.add(company);
    	}
    	return companyList;
    }

}
