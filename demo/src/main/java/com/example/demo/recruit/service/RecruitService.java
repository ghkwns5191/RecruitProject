package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.repository.RecruitRepository;

@Service
public class RecruitService {

    @Autowired
    private RecruitRepository recruitRepository;
    
    public List<Recruit> getRecruit() {
        List<Recruit> recruit = new ArrayList<Recruit>();
        recruitRepository.findAll().forEach(recruit::add);
        return recruit;
    }
    
    public List<Recruit> getRecruit(Member id_member) {
        List<Recruit> recruit = new ArrayList<Recruit>();
        recruitRepository.findById_member(id_member).forEach(recruit::add);
        return recruit;
    }
}
