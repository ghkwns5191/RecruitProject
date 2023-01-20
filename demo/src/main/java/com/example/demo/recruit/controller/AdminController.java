package com.example.demo.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.recruit.dto.MemberDto;
import com.example.demo.recruit.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

	@Autowired
	private final MemberService memberService;

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
}
