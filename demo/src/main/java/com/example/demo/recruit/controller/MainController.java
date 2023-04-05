package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.MemberDto;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Notice;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.CompanyService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.NoticeService;
import com.example.demo.recruit.service.RecruitService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final MemberService memberService;
    
    @Autowired
    private final CompanyService companyService;
    
    @Autowired
    private final RecruitService recruitService;
    
    @Autowired
    private final NoticeService noticeService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping(value= {"", "/"})
    public String main(Principal principal, Model model) {
        
        List<Recruit> recruitList = this.recruitService.getRecruit5();
        model.addAttribute("recruitList", recruitList);
        if (principal == null) {
            model.addAttribute("username", null);
            return "view/Home";
        } else {
            String username = principal.getName();
            Member member = memberService.getMember(username);
            String sort = member.getSort();
            if(companyService.getData(member) != null) {
                Company company = this.companyService.getData(member);
                model.addAttribute("company", company);
            }
            model.addAttribute("sort", sort);
            model.addAttribute("username", username);
            return "view/Home";
        }
    }

    @GetMapping("/join")
    public String newJoin(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "/view/Join";
    }

    @PostMapping("/join")
    public String join(MemberDto memberDto, Map<String, Object> ok) {
        System.out.println(memberDto.getUsername());
        memberService.createMember(memberDto, passwordEncoder);
        ok.put("message", "회원가입이 완료되었습니다.");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(Principal principal) {
        if (principal == null) {
            return "/view/Login";
        } else {
            return "redirect:/";
        }

    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", "아이디 혹은 비밀번호를 재확인 해주세요");
        return "/view/Login";
    }
    
    @GetMapping("/notice/list")
    public ModelAndView noticeList(Model model) {
        List<Notice> noticeList = this.noticeService.getNotice();
        model.addAttribute("noticeList", noticeList);
        
        return new ModelAndView("/view/noticeList");
    }

}
