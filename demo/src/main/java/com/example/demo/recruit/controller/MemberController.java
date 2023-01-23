package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.MemberDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	@Autowired
	private final MemberService memberService;

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

	@GetMapping("/detail")
	public ResponseEntity<Member> getMember(@RequestParam(required = false) Long id) {
		try {
			Member member = new Member();
			memberService.getMember(id);
			return new ResponseEntity<>(member, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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

}
