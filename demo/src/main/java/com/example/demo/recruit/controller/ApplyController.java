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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.ApplyDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicApplyService;
import com.example.demo.recruit.service.AcademicService;
import com.example.demo.recruit.service.ActivityService;
import com.example.demo.recruit.service.ApplyService;
import com.example.demo.recruit.service.CareerService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.RecruitService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private final ApplyService applyService;
    
    @Autowired
    private final RecruitService recruitService;
    
    @Autowired
    private final AcademicApplyService academicApplyService;

    @Autowired
    private final ResumeService resumeService;
    
    @Autowired
    private final MemberService memberService;
    
    @Autowired
    private final AcademicService academicService;
    
    @Autowired
    private final ActivityService activityService;
    
    @Autowired
    private final CareerService careerService;
    
    // 개인 회원의 채용공고 지원 내역을 조회하기 위해 사용
    @GetMapping("/listbymember")
    public ResponseEntity<List<Apply>> getListByMember(@RequestParam(required = false) Member member) {
        try {
            List<Apply> applyList = new ArrayList<Apply>();
            applyList = applyService.getapply(member);
            return new ResponseEntity<>(applyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 기업 회원의 채용공고에 지원한 지원 정보를 조회하기 위해 사용
    @GetMapping("/listbyrecruit")
    public ResponseEntity<List<Apply>> getListByRecruit(@RequestParam(required = false) Recruit recruit) {
        try {
            List<Apply> applyList = new ArrayList<Apply>();
            applyList = applyService.getapply(recruit);
            return new ResponseEntity<>(applyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 지원 정보 개별 조회를 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Apply> getApply(@RequestParam(required = false) Long id) {
        try {
            Apply apply = new Apply();
            apply = applyService.getapply(id);
            return new ResponseEntity<>(apply, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 개인 회원이 채용공고에 지원 시 해당 지원 정보를 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<Apply> inputData(@RequestBody ApplyDto applyDto, Principal principal, @RequestBody Long id) {
        try {
            Recruit recruit = this.recruitService.getRecruit(id);
            Apply apply = this.applyService.inputData(applyDto, principal, recruit);
            Member member = this.memberService.getMemberinfo(principal.getName());
            Resume resume = this.resumeService.getResume(member);
            
            // Academic 을 AcademicApply 에 저장
            List<Academic> academicList = this.academicService.getacademic(resume);
            this.academicApplyService.inputData(academicList, apply);
            
            // Activity 를 ActivityApply 에 저장
            List<Activity> activityList = this.activityService.getactivity(resume);
            
            
            // Career 를 CareerApply 에 저장
            List<Career> careerList = this.careerService.getcareer(resume);
            
            return new ResponseEntity<>(apply, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 지원 취소를 진행하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            applyService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
