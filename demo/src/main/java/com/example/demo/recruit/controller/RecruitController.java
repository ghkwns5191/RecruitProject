package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.recruit.entity.RecruitEntity;
import com.example.demo.recruit.repository.RecruitRepository;


@RequestMapping("/recruit")
@Controller
public class RecruitController {
	private RecruitRepository recruitRepository;
	
        
	@GetMapping("/recruit/list")
    public ResponseEntity<List<RecruitEntity>> recruitList(){
        try {
            List<RecruitEntity> recruitList = new ArrayList<RecruitEntity>();
            recruitRepository.findAll().forEach(recruitList::add);
            
            return new ResponseEntity<>(recruitList, HttpStatus.OK);
        } catch(Exception e) {
            return null;
        }
        
    }
	
	@PostMapping("/recruit/add")
	public ResponseEntity<RecruitEntity> addRecruit(@RequestBody RecruitEntity recruit){
	    try {
	        RecruitEntity newRecruit = recruitRepository.save(
	                    recruit.getRtitle(), recruit.getWriter(), recruit.getRegisterDate(), recruit.getModifyDate(), recruit.getCareer(), recruit.getSalary(), recruit.getWorkingDays(), recruit.getDetail(), recruit.getMessenger(), recruit.getHomePage(), recruit.getPhoneNumber());
	                
	        return new ResponseEntity<>(newRecruit, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null);
	    }
	}

}
