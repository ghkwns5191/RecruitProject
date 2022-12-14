package com.example.demo.recruit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
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

    // ?????? ????????? ????????? ?????????????????? ????????? ?????? ??????
    @GetMapping("/resume/new")
    public String getList(Model model) {
        model.addAttribute("resumeDto", new ResumeDto());
        return "????????? ?????? ?????????";
    }

    // ?????? ????????? ???????????? ???????????? ?????? ??????
    @GetMapping("/resume/{memberid}")
    public String getList(@RequestParam(required = false) Member member, Model model) {

        Resume resume = resumeService.getResume(member);
        model.addAttribute("resume", resume);
        return "????????? ?????? ?????????";
    }

    // ?????? ????????? ????????? ???????????? ?????? ??????
    @GetMapping("/resume/detail/{id_resume}")
    public ResponseEntity<Resume> getResume(@RequestParam(required = false) Long id) {
        try {
            Resume resume = new Resume();
            resume = resumeService.getResume(id);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ???????????? ???????????? DB ??? ???????????? ?????? ??????
    @PostMapping("/resume/input")
    public String inputData(@Valid ResumeDto resumeDto, BindingResult bindingResult, Model model,
            @RequestParam("imgfile") MultipartFile imgfile) {
        if (bindingResult.hasErrors()) {
            return "????????? ?????? ?????????";
        }
        try {
            resumeService.inputData(resumeDto, imgfile);
            return "????????? list ?????? ?????????";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("errorMessage", "????????? ?????? ??? ????????? ?????????????????????.");
            return "????????? list ?????? ?????????";
        }
    }

    // ???????????? ???????????? ?????? ??????
    @PutMapping("/resume/revise")
    public ResponseEntity<Resume> reviseData(@PathVariable("id") Long id, @RequestBody ResumeDto resumeDto) {
        try {
            Resume resume = resumeService.inputData(id, resumeDto);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ???????????? ???????????? ?????? ??????
    // ????????? ????????? ?????? ?????? ????????? ?????? ???????????? ???.
    @DeleteMapping("/resume/delete")
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
