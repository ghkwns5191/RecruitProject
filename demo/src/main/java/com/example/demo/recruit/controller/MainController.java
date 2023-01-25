package com.example.demo.recruit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.recruit.dto.MemberDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
	
	@Autowired
	private final MemberService memberService;
	
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String main(Principal principal, Model model) {
		if (principal == null) {
			model.addAttribute("username", null);
			return "view/Home";
		} else {
			String username = principal.getName();
			Member member = memberService.getMember(username);
			String sort = member.getSort();
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
	public String join(MemberDto memberDto) {
		System.out.println(memberDto.getUsername());
		memberService.createMember(memberDto, passwordEncoder);

		return "redirect:/";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "/view/Login";
	}

	@GetMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginError", "아이디 혹은 비밀번호를 재확인 해주세요");
		return "/view/Login";
	}

}
