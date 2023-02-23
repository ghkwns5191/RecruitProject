package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ImgfileRepository;
import com.example.demo.recruit.service.ImgfileService;
import com.example.demo.recruit.service.MemberService;
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
           
            System.out.println("작동함?");
            model.addAttribute("resumeDto", new ResumeDto());
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

}
