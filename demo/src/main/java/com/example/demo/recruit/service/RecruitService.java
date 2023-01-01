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

@Service
public class RecruitService {

    @Autowired
    private RecruitRepository recruitRepository;
    
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
    public Recruit getRecruit(Long id_recruit) {
        Optional<Recruit> recruitData = this.recruitRepository.findById(id_recruit);
        Recruit recruit = recruitData.get();
        return recruit;
    }
    
    // 입력받은 채용공고를 DB 에 저장하는 코드
    public Recruit inputData(RecruitDto recruitDto) {
        Recruit recruit = this.recruitRepository.save(new Recruit(
                recruitDto.getMember(),
                recruitDto.getRecruit_title(),
                recruitDto.getRecruit_writer(),
                LocalDate.now(),
                null,
                recruitDto.getRecruit_career(),
                recruitDto.getRecruit_salary(),
                recruitDto.getRecruit_workingdays(),
                recruitDto.getRecruit_detail(),
                recruitDto.getRecruit_phonenumber(),
                recruitDto.getRecruit_attn()));
        return recruit;
    }
    
    // DB 에 저장된 채용공고를 수정하는 코드
    public Recruit inputData(Long id_recruit, RecruitDto recruitDto) {
        Optional<Recruit> recruitData = this.recruitRepository.findById(id_recruit);
        Recruit recruit = recruitData.get();
        recruit.setRecruit_title(recruitDto.getRecruit_title());
        recruit.setRecruit_writer(recruitDto.getRecruit_writer());
        recruit.setRecruit_modifydate(LocalDate.now());
        recruit.setRecruit_career(recruitDto.getRecruit_career());
        recruit.setRecruit_salary(recruitDto.getRecruit_salary());
        recruit.setRecruit_workingdays(recruitDto.getRecruit_workingdays());
        recruit.setRecruit_detail(recruitDto.getRecruit_detail());
        recruit.setRecruit_phonenumber(recruitDto.getRecruit_phonenumber());
        recruit.setRecruit_attn(recruitDto.getRecruit_attn());
        this.recruitRepository.save(recruit);
        return recruit;
    }
    
    // DB 에 저장된 채용공고를 삭제하는 코드
    public void deleteData(Long id_recruit) {
        this.recruitRepository.deleteById(id_recruit);
    }
}
