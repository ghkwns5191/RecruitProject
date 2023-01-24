package com.example.demo.recruit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping("/resume")
	public String resumeList(Model model, Principal principal) {
		String username = principal.getName();
		Member member = memberService.getMember(username);
		Resume resume = resumeService.getResume(member);
		model.addAttribute("resume", resume);

		return "/view/mypage/Resume";
	}
	
	@GetMapping("/resume/new")
	public String newResume(Model model) {
		model.addAttribute("ResumeDto", new ResumeDto());
		return "/view/mypage/NewResume";
	}
	
	@PostMapping("/resume/new")
	public String newResume(@RequestBody ResumeDto resumeDto, Principal principal) {
		
		return "redirect:/view/mypage/Resume";
	}
}
