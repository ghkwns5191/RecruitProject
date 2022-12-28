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

@Service
public class ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    // 해당 회원이 지원한 지원 정보를 불러오는 코드
    public List<Apply> getapply(Member id_member) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findById_member(id_member).forEach(apply::add);
        return apply;
    }

    // 해당 채용공고에 지원한 지원 정보를 불러오는 코드
    public List<Apply> getapply(Recruit id_recruit) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findById_recruit(id_recruit).forEach(apply::add);
        return apply;
    }

    // 해당 지원 정보만 불러오는 코드
    public Apply getapply(Long id_apply) {
        Optional<Apply> applyData = this.applyRepository.findById(id_apply);
        Apply apply = applyData.get();
        return apply;
    }
    
    // 지원 정보를 입력받아 DB 에 저장하는 코드
    public Apply inputData(ApplyDto applyDto) {
        Apply apply = this.applyRepository.save(new Apply(
                applyDto.getId_member(),
                applyDto.getId_recruit(), 
                applyDto.getApply_applydate()));
        return apply;
    }
}
