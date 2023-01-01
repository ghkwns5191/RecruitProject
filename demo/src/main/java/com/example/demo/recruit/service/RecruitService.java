package com.example.demo.recruit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.RecruitDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitService {

    @Autowired
    private final RecruitRepository recruitRepository;
    
    // 전체 채용공고를 불러오는 코드
    public List<Recruit> getRecruit() {
        List<Recruit> recruit = new ArrayList<Recruit>();
        recruitRepository.findAll().forEach(recruit::add);
        return recruit;
    }
    
    // 해당 회원이 작성한 채용공고를 불러오는 코드
    public List<Recruit> getRecruit(Member member) {
        List<Recruit> recruit = new ArrayList<Recruit>();
        recruitRepository.findByMember(member).forEach(recruit::add);
        return recruit;
    }
    
    // 해당 채용공고만 불러오는 코드
    public Recruit getRecruit(Long id) {
        Optional<Recruit> recruitData = this.recruitRepository.findById(id);
        Recruit recruit = recruitData.get();
        return recruit;
    }
    
    // 입력받은 채용공고를 DB 에 저장하는 코드
    public Recruit inputData(RecruitDto recruitDto) {
        Recruit recruit = this.recruitRepository.save(new Recruit(
                recruitDto.getMember(),
                recruitDto.getTitle(),
                recruitDto.getWriter(),
                LocalDate.now(),
                null,
                recruitDto.getCareer(),
                recruitDto.getSalary(),
                recruitDto.getWorkingdays(),
                recruitDto.getDetail(),
                recruitDto.getPhonenumber(),
                recruitDto.getAttn()));
        return recruit;
    }
    
    // DB 에 저장된 채용공고를 수정하는 코드
    public Recruit inputData(Long id, RecruitDto recruitDto) {
        Optional<Recruit> recruitData = this.recruitRepository.findById(id);
        Recruit recruit = recruitData.get();
        recruit.setTitle(recruitDto.getTitle());
        recruit.setWriter(recruitDto.getWriter());
        recruit.setModifydate(LocalDate.now());
        recruit.setCareer(recruitDto.getCareer());
        recruit.setSalary(recruitDto.getSalary());
        recruit.setWorkingdays(recruitDto.getWorkingdays());
        recruit.setDetail(recruitDto.getDetail());
        recruit.setPhonenumber(recruitDto.getPhonenumber());
        recruit.setAttn(recruitDto.getAttn());
        this.recruitRepository.save(recruit);
        return recruit;
    }
    
    // DB 에 저장된 채용공고를 삭제하는 코드
    public void deleteData(Long id) {
        this.recruitRepository.deleteById(id);
    }
}
