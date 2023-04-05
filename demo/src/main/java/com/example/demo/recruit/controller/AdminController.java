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
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Notice;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    private final MemberService memberService;

    @Autowired
    private final NoticeService noticeService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/join")
    public String add(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "view/AdminJoin";
    }

    @PostMapping("/join")
    public String join(MemberDto memberDto) {
        memberService.createAdmin(memberDto, passwordEncoder);
        return "redirect:/";
    }

    @GetMapping("/notice/list")
	public ModelAndView noticeList(Principal principal, Model model, Map<String, Object> authority) {
        String url = "";
	    if (principal != null) {
	        Member member = this.memberService.getMemberinfo(principal.getName());
	        if (member.getRole().equals("ADMIN")) {
	            List<Notice> noticeList = this.noticeService.getNotice();
	            model.addAttribute("noticeList", noticeList);
	            url = "/view/admin/noticeList";
	        } else {
	            url = ""; // 사용자의 공지사항 리스트 페이졸 이동.
	        }
	    } else {
	        authority.put("authority", false);
	        url = "/view/Login";
	    }
	    return new ModelAndView(url);
	}
}
