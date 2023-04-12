package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.EducationDto;
import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.EducationService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationController {

    @Autowired
    private final EducationService educationService;
    
    @Autowired
    private final ResumeService resumeService;

    // 이력서 조회 시 교육내용을 함께 조회하기 위해 사용
    @GetMapping("/list")
    public ResponseEntity<List<Education>> getList(@RequestParam(required = false) Resume resume) {

        try {
            List<Education> educationList = new ArrayList<Education>();
            educationList = educationService.geteducation(resume);
            return new ResponseEntity<>(educationList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 해당 교육내용만 확인하기 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Education> getEducaction(@RequestParam(required = false) Long id) {
        try {
            Education education = new Education();
            education = educationService.geteducation(id);
            return new ResponseEntity<>(education, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 교육정보를 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<List<Education>> inputData(@RequestBody List<EducationDto> educationDtoList, Principal principal) {
        try {
            List<Education> educationList = educationService.inputData(educationDtoList, principal);
            return new ResponseEntity<>(educationList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //이력서상 교육정보를 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<List<Education>> reviseData(@PathVariable("id") Long id, List<EducationDto> educationDtoList) {
        try {
            Resume resume = this.resumeService.getResume(id);
            List<Education> educationList = educationService.inputData(resume, educationDtoList);
            return new ResponseEntity<>(educationList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 교육정보를 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            educationService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
