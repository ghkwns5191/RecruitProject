package com.example.demo.recruit.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.MemberDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.ERole;
import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Notice;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.ApplyService;
import com.example.demo.recruit.service.CompanyService;
import com.example.demo.recruit.service.ImgfileService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.NoticeService;
import com.example.demo.recruit.service.RecruitService;
import com.example.demo.recruit.service.ResumeService;

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

	@Autowired
	private final ResumeService resumeService;

	@Autowired
	private final ImgfileService imgfileService;

	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private final ApplyService applyService;

	@GetMapping(value = { "", "/" })
	public String main(Principal principal, Model model) {
		String location = "";

		List<Recruit> recruitList = this.recruitService.getRecruit5();
		List<Member> memberList = this.memberService.getMember(recruitList);
		List<Company> companyList = this.companyService.getData(memberList);
		model.addAttribute("recruitList", recruitList);
		model.addAttribute("recruitLength", recruitList.size());
		model.addAttribute("companyList", companyList);

		List<Notice> noticeList = this.noticeService.getNotice5();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeLength", noticeList.size());
		if (principal == null) {
			model.addAttribute("username", null);
			location = "view/Home";
		} else {

			String username = principal.getName();
			Member member = memberService.getMember(username);
			String role = member.getRole().toString();
			model.addAttribute("role", role);
			if (member.getRole().equals(ERole.USER)) {
				String sort = member.getSort();
				if (this.resumeService.getResume(member) != null) {
					Resume resume = this.resumeService.getResume(member);
					Imgfile imgfile = this.imgfileService.getimgfile(resume);
					String url = imgfile.getImgurl();
					model.addAttribute("url", url);
					model.addAttribute("originalname", imgfile.getOriname());
				}
				if (companyService.getData(member) != null) {
					Company company = this.companyService.getData(member);
					model.addAttribute("company", company);
				}
				model.addAttribute("sort", sort);
				model.addAttribute("username", username);
				location = "view/Home";
			} else if (member.getRole().equals(ERole.ADMIN)) {
				List<Member> memberList10 = this.memberService.getMember10();
				List<Recruit> recruitList10 = this.recruitService.getList10();
				List<Company> companyList_recruit = this.companyService.getList(recruitList10);
				List<Apply> applyList10 = this.applyService.getapply10(); 	
				
				model.addAttribute("memberList10", memberList10);
				model.addAttribute("recruitList10", recruitList10);
				model.addAttribute("companyList_recruit", companyList_recruit);
				model.addAttribute("applyList10", applyList10);
				
				List<Member> memberList_today = this.memberService.getMemberList(LocalDate.now());
				List<Member> memberList_yesterday = this.memberService.getMemberList(LocalDate.now().minusDays(1));
				int newMemberToday = memberList_today.size();
				int newMemberYesterday = memberList_yesterday.size();
				model.addAttribute("newMemberToday", newMemberToday);
				model.addAttribute("newMemberYesterday", newMemberYesterday);
				
				List<Recruit> recruitList_today = this.recruitService.getList(LocalDate.now());
				List<Recruit> recruitList_yesterday = this.recruitService.getList(LocalDate.now().minusDays(1));
				int newRecruitToday = recruitList_today.size();
				int newRecruitYesterday = recruitList_yesterday.size();
				model.addAttribute("newRecruitToday", newRecruitToday);
				model.addAttribute("newRecruitYesterday", newRecruitYesterday);
				
				List<Apply> applyList_today = this.applyService.getapply(LocalDate.now());
				List<Apply> applyList_yesterday = this.applyService.getapply(LocalDate.now().minusDays(1));
				int newApplyToday = applyList_today.size();
				int newApplyYesterday = applyList_yesterday.size();
				model.addAttribute("newApplyToday", newApplyToday);
				model.addAttribute("newApplyYesterday", newApplyYesterday);
				
				List<Recruit> recruitList_apply = this.recruitService.getList(applyList10);
				model.addAttribute("recruitList_apply", recruitList_apply);
			}
		}
		return location;
	}

	@GetMapping("/join")
	public String newJoin(Model model) {
		model.addAttribute("memberDto", new MemberDto());
		return "/view/Join";
	}

	@PostMapping("/join")
	public ResponseEntity<Member> join(MemberDto memberDto, Map<String, Object> ok) {
		System.out.println(memberDto.getUsername());
		Member member = memberService.createMember(memberDto, passwordEncoder);
		ok.put("message", "회원가입이 완료되었습니다.");
		return new ResponseEntity<>(member, HttpStatus.OK);
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

		return new ModelAndView("/view/NoticeList");
	}

	@GetMapping("/notice/detail/{id}")
	public ModelAndView noticeList(Model model, @PathVariable("id") Long id) {
		Notice notice = this.noticeService.getNotice(id);
		model.addAttribute("notice", notice);

		return new ModelAndView("/view/NoticeDetail");
	}

}
