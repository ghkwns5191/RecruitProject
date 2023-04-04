package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.AcademicApply;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicApplyService;
import com.example.demo.recruit.service.AcademicService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.RecruitService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/academicApply")
public class AcademicApplyController {

    @Autowired
    private final ResumeService resumeService;

    @Autowired
    private final AcademicService academicService;

    @Autowired
    private final MemberService memberService;

    @Autowired
    private final RecruitService recruitService;

    @Autowired
    private final AcademicApplyService academicApplyService;

    @PostMapping("/value")
    public ResponseEntity<List<AcademicApply>> inputData(Principal principal, Apply apply) {
        try {
            Member member = this.memberService.getMemberinfo(principal.getName());
            Resume resume = this.resumeService.getResume(member);
            List<Academic> academicList = this.academicService.getacademic(resume);
            List<AcademicApply> academicApplyList = this.academicApplyService.inputData(academicList, apply);
            return new ResponseEntity<>(academicApplyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

    }
}
