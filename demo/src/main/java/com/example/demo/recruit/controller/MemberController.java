package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.MemberDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Companyreview;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.ApplyService;
import com.example.demo.recruit.service.CompanyService;
import com.example.demo.recruit.service.CompanyreviewService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.RecruitService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @Autowired
    private final ResumeService resumeService;

    @Autowired
    private final CompanyService companyService;

    @Autowired
    private final RecruitService recruitService;
    
    @Autowired
    private final CompanyreviewService companyreviewService;
    
    @Autowired
    private final ApplyService applyService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/list")
    public ResponseEntity<List<Member>> getList() {
        try {
            List<Member> memberList = new ArrayList<Member>();
            memberList = memberService.getMember();
            return new ResponseEntity<>(memberList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sendMemberData")
    public ResponseEntity<Member> getMember(Principal principal, Model model) {
        try {
            Member member = memberService.getMember(principal.getName());
            System.out.println(principal.getName());
            System.out.println(member);
            return new ResponseEntity<>(member, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/usernamecheck")
    public String username(@RequestParam("username") String username, Model model) {
        boolean result = memberService.checkUsername(username);
        model.addAttribute("result", result);
        System.out.println(result);
        return "/view/CheckUsername :: #checkresult";
    }

    @GetMapping("/usernamecheck")
    public String usernamecheck(Model model) {
        String username = "";
        model.addAttribute("username", username);
        return "/view/CheckUsername";
    }

    @PutMapping("/revise")
    public ResponseEntity<Member> reviseMemberinfo(@RequestBody MemberDto memberDto, Principal principal) {
        try {
            Member member = this.memberService.getMemberinfo(principal.getName());
            Member revised = null;
            if (passwordEncoder.matches(memberDto.getPassword(), member.getPassword())) {
                revised = this.memberService.reviseMember(member, memberDto);
                return new ResponseEntity<>(revised, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 회원 강퇴
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") Long id) {
        try {
            Member member = this.memberService.getMember(id);
            if (member.getSort().equals("company")) {
                Company company = this.companyService.getData(member);
                this.companyService.deleteData(company.getId());
                
                List<Recruit> recruitList = this.recruitService.getRecruit(member);
                for (int i = 0; i < recruitList.size(); i++) {
                    this.recruitService.deleteData(recruitList.get(i).getId());
                }
                
            } else if (member.getSort().equals("individual")) {
                Resume resume = this.resumeService.getResume(member);
                this.resumeService.deleteData(resume.getId());
                
                List<Companyreview> companyReviewList = this.companyreviewService.getcompanyreview(member);
                for (int i = 0; i < companyReviewList.size(); i++) {
                    this.companyreviewService.deleteCompany(companyReviewList.get(i).getId());
                }
                
                

            }
            this.memberService.deleteMember(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 회원 자진 탈퇴
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteMember(Principal principal) {
        try {
            String username = principal.getName();
            this.memberService.deleteMember(username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
