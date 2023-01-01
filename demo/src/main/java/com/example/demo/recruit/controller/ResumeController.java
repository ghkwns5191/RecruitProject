package com.example.demo.recruit.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicService;
import com.example.demo.recruit.service.ActivityService;
import com.example.demo.recruit.service.CareerService;
import com.example.demo.recruit.service.CertificateService;
import com.example.demo.recruit.service.EducationService;
import com.example.demo.recruit.service.LanguagesService;
import com.example.demo.recruit.service.OverseasexperienceService;
import com.example.demo.recruit.service.PortfolioService;
import com.example.demo.recruit.service.ResumeService;

@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    
    @Autowired
    private AcademicService academicService;
    
    @Autowired
    private ActivityService activityService;
    
    @Autowired
    private CareerService careerService;
    
    @Autowired
    private CertificateService certificateService;
    
    @Autowired
    private EducationService educationService;
    
    @Autowired
    private LanguagesService languagesService;
    
    @Autowired
    private OverseasexperienceService overseasexperienceService;
    
    @Autowired
    private PortfolioService portfolioService;
    
    // 해당 회원의 이력서를 조회하기 위해 사용
    @GetMapping("/resume/listbymember")
    public ResponseEntity<List<Resume>> getList(@RequestParam(required = false) Member member) {
        try {
            List<Resume> resume = new ArrayList<Resume>();
            resume = resumeService.getResume(member);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 해당 이력서 정보를 조회하기 위해 사용
    @GetMapping("/resume/detail")
    public ResponseEntity<Resume> getResume(@RequestParam(required = false) Long id_resume) {
        try {
            Resume resume = new Resume();
            resume = resumeService.getResume(id_resume);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서를 작성받아 DB 에 저장하기 위해 사용
    @PostMapping("/resume/input")
    public ResponseEntity<Resume> inputData(@RequestBody ResumeDto resumeDto) {
        try {
            Resume resume = resumeService.inputData(resumeDto);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서를 수정하기 위해 사용
    @PutMapping("/resume/revise")
    public ResponseEntity<Resume> reviseData(@PathVariable("id_resume") Long id_resume, @RequestBody ResumeDto resumeDto) {
        try {
            Resume resume = resumeService.inputData(id_resume, resumeDto);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서를 삭제하기 위해 사용
    // 이력서 하위에 있는 세부 항목들 모두 삭제해야 함.
    @DeleteMapping("/resume/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id_resume") Long id_resume) {
        try {
            academicService.deleteResume(id_resume);
            activityService.deleteResume(id_resume);
            careerService.deleteResume(id_resume);
            certificateService.deleteResume(id_resume);
            educationService.deleteResume(id_resume);
            languagesService.deleteResume(id_resume);
            overseasexperienceService.deleteResume(id_resume);
            portfolioService.deleteResume(id_resume);
            resumeService.deleteData(id_resume);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
