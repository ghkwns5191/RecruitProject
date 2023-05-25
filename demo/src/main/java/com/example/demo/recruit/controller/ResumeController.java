package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicService;
import com.example.demo.recruit.service.ActivityService;
import com.example.demo.recruit.service.CareerService;
import com.example.demo.recruit.service.CertificateService;
import com.example.demo.recruit.service.EducationService;
import com.example.demo.recruit.service.ImgfileService;
import com.example.demo.recruit.service.LanguagesService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.OverseasexperienceService;
import com.example.demo.recruit.service.PortfolioService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController {

    @Autowired
    private final ResumeService resumeService;

    @Autowired
    private final AcademicService academicService;

    @Autowired
    private final ActivityService activityService;

    @Autowired
    private final CareerService careerService;

    @Autowired
    private final CertificateService certificateService;

    @Autowired
    private final EducationService educationService;

    @Autowired
    private final LanguagesService languagesService;

    @Autowired
    private final OverseasexperienceService overseasexperienceService;

    @Autowired
    private final PortfolioService portfolioService;

    @Autowired
    private final MemberService memberService;

    @Autowired
    private final ImgfileService imgfileService;

    // 해당 회원의 이력서 작성페이지를 띄우기 위해 사용


    // 해당 이력서 정보를 조회하기 위해 사용
    @GetMapping("/detail/{id}")
    public ResponseEntity<Resume> getResume(@PathVariable("id") Long id) {
        try {
            Resume resume = resumeService.getResume(id);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
        	System.out.println(e);
        	
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서를 작성받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<Resume> inputData(@Valid ResumeDto resumeDto, Model model,
            Principal principal) throws Exception {

        System.out.println("작동확인");
        Resume resume = resumeService.inputData(resumeDto, principal);
        return new ResponseEntity<>(resume, HttpStatus.OK);

    }

    // 이력서를 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<Resume> reviseData(@PathVariable("id") Long id, @RequestBody ResumeDto resumeDto) {
        try {
            Resume resume = resumeService.inputData(id, resumeDto);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서를 삭제하기 위해 사용
    // 이력서 하위에 있는 세부 항목들 모두 삭제해야 함.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            academicService.deleteResume(id);
            activityService.deleteResume(id);
            careerService.deleteResume(id);
            certificateService.deleteResume(id);
            educationService.deleteResume(id);
            languagesService.deleteResume(id);
            overseasexperienceService.deleteResume(id);
            portfolioService.deleteResume(id);
            resumeService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
