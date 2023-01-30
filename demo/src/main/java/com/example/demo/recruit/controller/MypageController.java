package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
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

    @GetMapping("/accountinfo")
    public String mypage() {

        return "/view/mypage/AccountInfo";
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
            model.addAttribute("resume", resume);
            return new ModelAndView("/view/mypage/Resume");
        } catch(NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("view/Login");
        }
    }
    
    @GetMapping("/error")
    public ResponseEntity errorMsg(Principal principal) {
        if(principal == null) {
            return new ResponseEntity("로그인이 필요한 페이지 입니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.OK);
        }
    }
    
    @GetMapping("/principalcheck")
    public ResponseEntity sessioncheck(Principal principal) {
        if(principal != null) {
            return new ResponseEntity(principal, HttpStatus.OK);
        } else {
            return null;
        }
    }
 
    @GetMapping("/resume/new")
    public String newResume(Model model) {
        System.out.println("작동함?");
        model.addAttribute("resumeDto", new ResumeDto());
        return "/view/mypage/NewResume";
    }

    @PostMapping("/resume/new")
    public String newResume(@RequestBody ResumeDto resumeDto, MultipartFile imgfile, Principal principal) {

        return "redirect:/view/mypage/Resume";
    }

}
