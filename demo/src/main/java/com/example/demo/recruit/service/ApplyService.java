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

    public List<Apply> getapply(Member id_member) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findById_member(id_member).forEach(apply::add);
        return apply;
    }

    public List<Apply> getapply(Recruit id_recruit) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findById_recruit(id_recruit).forEach(apply::add);
        return apply;
    }

    public Apply getapply(Long id_apply) {
        Optional<Apply> applyData = this.applyRepository.findById(id_apply);
        Apply apply = applyData.get();
        return apply;
    }
    
    public Apply inputData(ApplyDto applyDto) {
        Apply apply = this.applyRepository.save(new Apply(applyDto.getId_member(), applyDto.getId_recruit(), applyDto.getApply_applydate()));
        return apply;
    }
}
