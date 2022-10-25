package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.demo.recruit.entity.RecruitEntity;
import com.example.demo.recruit.repository.RecruitRepository;

@Controller
public class RecruitController {
	private RecruitRepository recruitRepository;
        
    public ResponseEntity<List<RecruitEntity>> recruitList(){
        try {
            List<RecruitEntity> recruitList = new ArrayList<RecruitEntity>();
            recruitRepository.findAll().forEach(recruitList::add);
            
            return new ResponseEntity<>(recruitList, HttpStatus.OK);
        } catch(Exception e) {
            return null;
        }
        
    }

}
