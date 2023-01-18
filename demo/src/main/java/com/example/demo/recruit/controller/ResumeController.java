package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.List;

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
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.recruit.dto.ImgfileDto;
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

    @Autowired
    private final MemberService memberService;

    @Autowired
    private final ImgfileService imgfileService;

    // 해당 회원의 이력서 작성페이지를 띄우기 위해 사용
    @GetMapping("/mypage/resume/new")
    public String getList(Model model) {
        model.addAttribute("resumeDto", new ResumeDto());
        model.addAttribute("imgfileDto", new ImgfileDto());
        return "이력서 작성 페이지";
    }

    // 해당 회원의 이력서를 조회하기 위해 사용
    @GetMapping("/mypage/resume")
    public String getList(Principal principal, Model model) {
        
        try {
        String memberData = principal.getName();
        Member member = memberService.getMember(memberData);
        Resume resume = resumeService.getResume(member);
        List<Academic> academicList = academicService.getacademic(resume);
        List<Activity> activityList = activityService.getactivity(resume);
        List<Career> careerList = careerService.getcareer(resume);
        List<Certificate> certificateList = certificateService.getcertificate(resume);
        List<Education> educationList = educationService.geteducation(resume);
        Imgfile imgfile = imgfileService.getimgfile(resume);
        List<Languages> languagesList = languagesService.getlanguages(resume);
        List<Overseasexperience> overseasExperienceList = overseasexperienceService.getoverseasexperience(resume);
        List<Portfolio> portfolioList = portfolioService.getPortfolio(resume);

        model.addAttribute("member", member);
        model.addAttribute("resume", resume);
        model.addAttribute("academicList", academicList);
        model.addAttribute("activityList", activityList);
        model.addAttribute("careerList", careerList);
        model.addAttribute("certificateList", certificateList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("imgfile", imgfile);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("overseasExperienceList", overseasExperienceList);
        model.addAttribute("portfolioList", portfolioList);

        return "/view/mypage/ViewResume";
        } catch (Unauthorized e) {
            return "/view/login";
        }
    }

    // 해당 이력서 정보를 조회하기 위해 사용
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

    // 이력서를 작성받아 DB 에 저장하기 위해 사용
    @PostMapping("/resume/input")
    public String inputData(@Valid ResumeDto resumeDto, BindingResult bindingResult, Model model,
            @RequestParam("imgfile") MultipartFile imgfile) {
        if (bindingResult.hasErrors()) {
            return "이력서 작성 페이지";
        }
        try {
            resumeService.inputData(resumeDto, imgfile);
            return "이력서 list 조회 페이지";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("errorMessage", "이력서 등록 중 오류가 발생하였습니다.");
            return "이력서 list 조회 페이지";
        }
    }

    // 이력서를 수정하기 위해 사용
    @PutMapping("/resume/revise")
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
