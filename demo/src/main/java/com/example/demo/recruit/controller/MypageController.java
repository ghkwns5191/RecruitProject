package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ImgfileRepository;
import com.example.demo.recruit.service.AcademicService;
import com.example.demo.recruit.service.ActivityService;
import com.example.demo.recruit.service.ApplyService;
import com.example.demo.recruit.service.CareerService;
import com.example.demo.recruit.service.CertificateService;
import com.example.demo.recruit.service.EducationService;
import com.example.demo.recruit.service.ImgfileService;
import com.example.demo.recruit.service.LanguagesService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.OverseasexperienceService;
import com.example.demo.recruit.service.PortfolioService;
import com.example.demo.recruit.service.RecruitService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    @Autowired
    private final MemberService memberService;

    @Autowired
    private final ResumeService resumeService;

    @Autowired
    private final ImgfileRepository imgfileRepository;

    @Autowired
    private final ImgfileService imgfileService;

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
    private final LanguagesService LanguageService;

    @Autowired
    private final OverseasexperienceService oeService;

    @Autowired
    private final PortfolioService portfolioService;

    @Autowired
    private final ApplyService applyService;

    @Autowired
    private final RecruitService recruitService;

    @GetMapping(value = { "", "/" })
    public String mypagehome() {

        return "redirect:/mypage/accountinfo";
    }

    @GetMapping("/accountinfo")
    public ModelAndView mypage(Principal principal, Map<String, Object> check) {
        try {
            String username = principal.getName();
            System.out.println(username);
            return new ModelAndView("/view/mypage/AccountInfo");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("view/Login");
        }

    }

    @GetMapping("/resume")
    public ModelAndView resumeList(Model model, Principal principal, Map<String, Object> check) {
        try {

            String username = principal.getName();
            System.out.println(username);
            Member member = memberService.getMember(username);
            System.out.println(member);
            Resume resume = resumeService.getResume(member);
            System.out.println(resume);
            if (imgfileService.getimgfile(resume) != null) {
                Imgfile imgfile = imgfileService.getimgfile(resume);
                String imgurl = imgfile.getImgurl();
                model.addAttribute("imgurl", imgurl);
                System.out.println(imgfile.getImgurl());
            }
            model.addAttribute("resume", resume);

            return new ModelAndView("/view/mypage/Resume");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("view/Login");
        }
    }

    @GetMapping("/resume/detail/{id}")
    public ModelAndView resumeList(@PathVariable Long id, Model model, Principal principal, Map<String, Object> check) {
        try {

            String username = principal.getName();
            System.out.println(username);
            Member member = memberService.getMember(username);
            System.out.println(member);
            Resume resume = resumeService.getResume(id);
            System.out.println(resume);
            List<Academic> academicList = this.academicService.getacademic(resume);
            List<Activity> activityList = this.activityService.getactivity(resume);
            List<Career> careerList = this.careerService.getcareer(resume);
            List<Certificate> certificateList = this.certificateService.getcertificate(resume);
            List<Education> educationList = this.educationService.geteducation(resume);
            List<Languages> languagesList = this.LanguageService.getlanguages(resume);
            List<Overseasexperience> oeList = this.oeService.getoverseasexperience(resume);
            List<Portfolio> portfolioList = this.portfolioService.getPortfolio(resume);

            if (imgfileService.getimgfile(resume) != null) {
                Imgfile imgfile = imgfileService.getimgfile(resume);
                String imgurl = imgfile.getImgurl();
                model.addAttribute("imgurl", imgurl);
                System.out.println(imgfile.getImgurl());

            }

            if (resume.getMember() == member && resume != null) {
                model.addAttribute("member", member);
                model.addAttribute("resume", resume);
                if (academicList != null)
                    model.addAttribute("academicList", academicList);
                if (activityList != null)
                    model.addAttribute("activityList", activityList);
                if (careerList != null)
                    model.addAttribute("careerList", careerList);
                if (certificateList != null)
                    model.addAttribute("certificateList", certificateList);
                if (educationList != null)
                    model.addAttribute("educationList", educationList);
                if (languagesList != null)
                    model.addAttribute("languagesList", languagesList);
                if (oeList != null)
                    model.addAttribute("oeList", oeList);
                if (portfolioList != null)
                    model.addAttribute("portfolioList", portfolioList);
            }

            return new ModelAndView("/view/mypage/ResumeDetail");

        } catch (NullPointerException e) {
            /*
             * principal 이 null 로 되어있으면 (계정 접속이 되어있지 않으면)
             * NullPointerException 발생시켜서 check 값을 true로 전송
             * check 값이 true 가 되면 경고문 발생과 함께 로그인 페이지로 이동.
             */
            check.put("check", true);
            return new ModelAndView("view/Login");
        }
    }

    @GetMapping("/error")
    public ResponseEntity errorMsg(Principal principal) {
        if (principal == null) {
            return new ResponseEntity("로그인이 필요한 페이지 입니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.OK);
        }
    }

    @GetMapping("/resume/new")
    public ModelAndView newResume(Model model, Principal principal, Map<String, Object> check) {
        try {
            String username = principal.getName();
            System.out.println("작동함?");
            model.addAttribute("resumeDto", new ResumeDto());
            model.addAttribute("username", username);
            return new ModelAndView("/view/mypage/NewResume");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("view/Login");
        }
    }

    @PostMapping("/resume/new")
    public String newResume(ResumeDto resumeDto, MultipartFile imgfile, Principal principal) {
        System.out.println("반응함?");
        return "redirect:/view/mypage/Resume";
    }

    @GetMapping("/companyinput")
    public ModelAndView newCompany(Map<String, Object> check, Principal principal, Model model) {
        try {
            String username = principal.getName();
            Member member = this.memberService.getMemberinfo(username);
            String sort = member.getSort();
            model.addAttribute("sort", sort);
            return new ModelAndView("/view/mypage/NewCompany");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("view/Login");
        }
    }

    // 사용자 지원 현황 리스트
    @GetMapping("/user/applyinfo")
    public ModelAndView userApplyinfo(Principal principal, Model model, Map<String, Object> check) {
        try {
            Member member = this.memberService.getMemberinfo(principal.getName());
            List<Apply> applyList = this.applyService.getapply(member);
            model.addAttribute("applyList", applyList);
            return new ModelAndView("/view/mypage/");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("view/Login");
        }
    }

    // 기업회원 작성 채용공고 리스트
    @GetMapping("/company/recruitList")
    public ModelAndView recruitApplyinfo(Principal principal, Model model, Map<String, Object> check) {
        try {
            Member member = this.memberService.getMemberinfo(principal.getName());
            List<Recruit> recruitList = this.recruitService.getRecruit(member);
            model.addAttribute("recruitList", recruitList);
            return new ModelAndView("/view/mypage/");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("view/Login");
        }
    }

}
