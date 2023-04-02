package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.ApplyDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.repository.ApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplyService {

    @Autowired
    private final ApplyRepository applyRepository;

    // 해당 회원이 지원한 지원 정보를 불러오는 코드
    public List<Apply> getapply(Member member) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findByMember(member).forEach(apply::add);
        return apply;
    }

    // 해당 채용공고에 지원한 지원 정보를 불러오는 코드
    public List<Apply> getapply(Recruit recruit) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findByRecruit(recruit).forEach(apply::add);
        return apply;
    }

    // 해당 지원 정보만 불러오는 코드
    public Apply getapply(Long id) {
        Optional<Apply> applyData = this.applyRepository.findById(id);
        Apply apply = applyData.get();
        return apply;
    }
    
    // 지원 정보를 입력받아 DB 에 저장하는 코드
    public Apply inputData(ApplyDto applyDto) {
        Apply apply = this.applyRepository.save(new Apply(
                applyDto.getMember(),
                applyDto.getRecruit(), 
                applyDto.getApplydate()));
        return apply;
    }
    
    // 지원 정보를 삭제하는 코드
    public void deleteData(Long id) {
        this.applyRepository.deleteById(id);
    }
    
    // 회원정보 및 채용공고 사이트를 이용하여 지원내역을 찾는 코드
    public Apply getapply(Recruit recruit, Member member) {
        Apply apply = this.applyRepository.findByRecruitAndMember(recruit, member);
        return apply;
    }
}
