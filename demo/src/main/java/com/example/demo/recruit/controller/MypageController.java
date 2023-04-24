package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.AcademicApply;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.ActivityApply;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.CareerApply;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.CertificateApply;
import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.EducationApply;
import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.ImgfileApply;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.LanguagesApply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.OverseasexperienceApply;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.PortfolioApply;
import com.example.demo.recruit.entity.Portfoliofile;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicApplyService;
import com.example.demo.recruit.service.AcademicService;
import com.example.demo.recruit.service.ActivityApplyService;
import com.example.demo.recruit.service.ActivityService;
import com.example.demo.recruit.service.ApplyService;
import com.example.demo.recruit.service.CareerApplyService;
import com.example.demo.recruit.service.CareerService;
import com.example.demo.recruit.service.CertificateApplyService;
import com.example.demo.recruit.service.CertificateService;
import com.example.demo.recruit.service.EducationApplyService;
import com.example.demo.recruit.service.EducationService;
import com.example.demo.recruit.service.ImgfileApplyService;
import com.example.demo.recruit.service.ImgfileService;
import com.example.demo.recruit.service.LanguagesApplyService;
import com.example.demo.recruit.service.LanguagesService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.OverseasexperienceApplyService;
import com.example.demo.recruit.service.OverseasexperienceService;
import com.example.demo.recruit.service.PortfolioApplyService;
import com.example.demo.recruit.service.PortfolioService;
import com.example.demo.recruit.service.PortfoliofileService;
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

    @Autowired
    private final PortfoliofileService portfoliofileService;

    @Autowired
    private final AcademicApplyService academicApplyService;

    @Autowired
    private final ActivityApplyService activityApplyService;

    @Autowired
    private final CareerApplyService careerApplyService;

    @Autowired
    private final CertificateApplyService certificateApplyService;

    @Autowired
    private final EducationApplyService educationApplyService;

    @Autowired
    private final ImgfileApplyService imgfileApplyService;

    @Autowired
    private final LanguagesApplyService languagesApplyService;

    @Autowired
    private final OverseasexperienceApplyService overseasexperienceApplyService;

    @Autowired
    private final PortfolioApplyService portfolioApplyService;

    @GetMapping(value = { "", "/" })
    public ModelAndView mypagehome(Principal principal, Map<String, Object> check, Model model) {
        String url = "";
        try {
            if (principal != null) {
                Member user = this.memberService.getMemberinfo(principal.getName());
                model.addAttribute("member", user);
                model.addAttribute("sort", user.getSort());
                model.addAttribute("name", user.getName());
                if (user.getSort().equals("individual")) {
                    List<Apply> applyList = this.applyService.getapply5(user);
                    Resume resume = this.resumeService.getResume(user);
                    List<Recruit> recruitList = this.recruitService.getList(applyList);
                    Imgfile imgfile = this.imgfileService.getimgfile(resume);
                    String imgurl = imgfile.getImgurl();
                    model.addAttribute("applyList", applyList);
                    model.addAttribute("resume", resume);
                    model.addAttribute("recruitList", recruitList);
                    model.addAttribute("imgurl", imgurl);

                } else if (user.getSort().equals("company")) {

                }
                url = "/view/mypage/MypageHome";
            } else {
                check.put("check", true);
                url = "/view/Login";
            }
            return new ModelAndView(url);
        } catch (Exception e) {
            e.printStackTrace();
            url = "/view/Home";
            return new ModelAndView(url);
        }

    }

    @GetMapping("/accountinfo")
    public ModelAndView mypage(Principal principal, Map<String, Object> check) {
        try {
            String username = principal.getName();
            System.out.println(username);
            return new ModelAndView("/view/mypage/AccountInfo");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("/view/Login");
        }

    }

    @GetMapping("/user/resume")
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

    @GetMapping("/user/resume/detail/{id}")
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
                if (portfolioList != null) {
                    List<String> urlList = new ArrayList<>();
                    for (int i = 0; i < portfolioList.size(); i++) {
                        String url = "";
                        if (this.portfoliofileService.getfile(portfolioList.get(i)) != null) {
                            Portfoliofile portfoliofile = this.portfoliofileService.getfile(portfolioList.get(i));
                            url = portfoliofile.getFileurl();
                        } else {
                            url = "";
                        }

                        urlList.add(url);
                    }
                    model.addAttribute("urlList", urlList);
                    model.addAttribute("portfolioList", portfolioList);
                }
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

    @GetMapping("/user/resume/new")
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

    @GetMapping("/user/resume/revise/{id}")
    public ModelAndView forupdateResume(@PathVariable("id") Long id, Model model, Principal principal,
            Map<String, Object> check) {
        if (principal != null) {
            Member member = this.memberService.getMemberinfo(principal.getName());
            Resume resume = this.resumeService.getResume(id);
            model.addAttribute("resume", resume);
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
                if (portfolioList != null) {
                    List<String> urlList = new ArrayList<>();
                    for (int i = 0; i < portfolioList.size(); i++) {
                        String url = "";
                        if (this.portfoliofileService.getfile(portfolioList.get(i)) != null) {
                            Portfoliofile portfoliofile = this.portfoliofileService.getfile(portfolioList.get(i));
                            url = portfoliofile.getFileurl();
                        } else {
                            url = "";
                        }

                        urlList.add(url);
                    }
                    model.addAttribute("urlList", urlList);
                    model.addAttribute("portfolioList", portfolioList);
                }

            }

            return new ModelAndView("/view/mypage/ReviseResume");
        } else {
            check.put("check", true);
            return new ModelAndView("/view/Login");
        }
    }

    @GetMapping("/company/input")
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
        String url = "";
        if (principal != null) {
            Member member = this.memberService.getMemberinfo(principal.getName());
            List<Apply> applyList = this.applyService.getapply(member);
            List<Recruit> recruitList = this.recruitService.getList(applyList);
            model.addAttribute("applyList", applyList);
            model.addAttribute("recruitList", recruitList);
            url = "/view/mypage/ApplyListBymember";
        } else {
            check.put("check", true);
            url = "/view/Login";

        }

        return new ModelAndView(url);
    }

    @GetMapping("/user/applydetail/{id}")
    public ModelAndView userApplyDetail(@PathVariable("id") Long id, Principal principal, Map<String, Object> check,
            Model model) {
        String url = "";
        if (principal != null) {
            Apply apply = this.applyService.getapply(id);
            Member member = this.memberService.getMemberinfo(principal.getName());
            if (member.getUsername().equals(apply.getMember().getUsername())) {
                Recruit recruit = apply.getRecruit();
                List<AcademicApply> academicApplyList = this.academicApplyService.getList(apply);
                List<ActivityApply> activityApplyList = this.activityApplyService.getList(apply);
                List<CareerApply> careerApplyList = this.careerApplyService.getList(apply);
                List<CertificateApply> certificateApplyList = this.certificateApplyService.getList(apply);
                List<EducationApply> educationApplyList = this.educationApplyService.getList(apply);
                ImgfileApply imgfileApply = this.imgfileApplyService.getData(apply);
                List<LanguagesApply> languagesApplyList = this.languagesApplyService.getList(apply);
                List<OverseasexperienceApply> oeApplyList = this.overseasexperienceApplyService.getList(apply);
                List<PortfolioApply> portfolioApplyList = this.portfolioApplyService.getList(apply);
                model.addAttribute("apply", apply);
                model.addAttribute("recruit", recruit);
                url = "/view/mypage/"; // 해당 지원 상세페이지로 이동 필요
            } else {
                check.put("check", true);
                url = ""; // 사용자 지원 현황 리스트 페이지로 전환 필요 경고문과 함께
            }

        } else {
            check.put("check", true);
            url = "view/Login";
        }
        return new ModelAndView(url);
    }

    // 기업회원 작성 채용공고 리스트
    @GetMapping("/company/recruit/list")
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

    @GetMapping("/company/recruit/detail/{id}")
    public ModelAndView recruitdetailandapplylist(Principal principal, Model model, Map<String, Object> check,
            @PathVariable("id") Long id,
            @PageableDefault(page = 0, size = 10, sort = "applydate", direction = Sort.Direction.DESC) Pageable pageable) {
        String url = "";
        if (principal != null) {
            Recruit recruit = this.recruitService.getRecruit(id);
            Member member = this.memberService.getMemberinfo(principal.getName());
            if (member.getUsername().equals(recruit.getMember().getUsername())) {
                Page<Apply> applyList = this.applyService.getapply(recruit, pageable);
                List<Integer> certificatenumber = this.certificateApplyService.getnumber(applyList);
                List<Integer> careernumber = this.careerApplyService.getnumber(applyList);
                List<Integer> languagesnumber = this.languagesApplyService.getnumber(applyList);

                model.addAttribute("recruit", recruit);
                model.addAttribute("applyList", applyList);
                model.addAttribute("certificatenumber", certificatenumber);
                model.addAttribute("careernumber", careernumber);
                model.addAttribute("languagesnumber", languagesnumber);

                url = "/view/mypage/"; // 채용공고 상세 및 채용공고마다 지원 현황 리스트 보여주는 페이지로 이동
            } else {
                check.put("check", true);
                url = ""; // 사용자 작성 채용공고 리스트로 이동.
            }
        } else {
            check.put("check", true);
            url = "view/Login";
        }

        return new ModelAndView(url);
    }

    @GetMapping("/company/recruit/detail/applyinfo/{id}")
    public ModelAndView applyinfotorecruit(Principal principal, Model model, Map<String, Object> check,
            @PathVariable("id") Long id) {
        String url = "";
        if (principal != null) {
            Apply apply = this.applyService.getapply(id);
            Member member = this.memberService.getMemberinfo(principal.getName());
            if (member.getUsername().equals(apply.getMember().getUsername())) {
                model.addAttribute("apply", apply);
                url = "/view/mypage"; // 채용공고 상세 및 채용공고마다 지원 현황 리스트 보여주는 페이지로 이동
            } else {
                check.put("check", true);
                url = ""; // 사용자 작성 채용공고 리스트로 이동.
            }
        } else {
            check.put("check", true);
            url = "view/Login";
        }

        return new ModelAndView(url);
    }

}
