package com.example.demo.recruit.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.RecruitDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Company;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.ApplyService;
import com.example.demo.recruit.service.CompanyService;
import com.example.demo.recruit.service.MemberService;
import com.example.demo.recruit.service.RecruitService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/recruitpage")
@RequiredArgsConstructor
public class RecruitpageController {

    @Autowired
    private final RecruitService recruitService;

    @Autowired
    private final CompanyService companyService;

    @Autowired
    private final ApplyService applyService;

    @Autowired
    private final MemberService memberService;

    @GetMapping("/list")
    public ModelAndView recruitList(
            @PageableDefault(page = 0, size = 20, sort = "registerdate", direction = Sort.Direction.DESC) Pageable pageable,
            Model model, String searchKeyword, Map<String, Object> map, Principal principal) {
        List<Recruit> list = this.recruitService.getRecruit();
        Page<Recruit> recruitList = null;
        if (searchKeyword == null) {
            recruitList = this.recruitService.getRecruit(pageable);

        } else if (searchKeyword != null) {
            recruitList = this.recruitService.getRecruit(pageable, searchKeyword);
        }
        int nowPage = recruitList.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 9, recruitList.getTotalPages());

        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        if (recruitList.getTotalPages() == 0) {
            endPage = 1;
        }
        model.addAttribute("endPage", endPage);
        model.addAttribute("size", list.size());
        model.addAttribute("recruitList", recruitList);
        model.addAttribute("totalPages", recruitList.getTotalPages());
        model.addAttribute("searchKeyword", searchKeyword);
        System.out.println(searchKeyword);
        
        
        if (principal != null) {
            String username = principal.getName();
            Member member = this.memberService.getMemberinfo(username);
            String sort = member.getSort();
            model.addAttribute("sort", sort);
        }
        
        return new ModelAndView("/view/recruit/RecruitList");

    }

    @GetMapping("/new")
    public ModelAndView newRecruit(Model model, Map<String, Object> check, Principal principal) {
        try {
            String username = principal.getName();
            model.addAttribute("recruitDto", new RecruitDto());
            model.addAttribute("username", username);
            return new ModelAndView("/view/recruit/NewRecruit");
        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("/view/Login");
        }
    }

    // url 에서 id 값을 뽑아내서 parameter 로 활용 / recruit 상세 페이지로 이동
    @GetMapping("/detail/{id}")
    public ModelAndView recruitDetail(Model model, @PathVariable("id") Long id, Map<String, Object> check,
            Principal principal) {
        Recruit recruit = this.recruitService.getRecruit(id);
        // location 변수 선언 및 초기화 (if 절로 정한 각 조건마다 location 값 지정하여 페이지 이동)
        String location = "";
        model.addAttribute("principal", principal);
        // 유호하지 않은 id 값이 들어가서 recruit= null 일 경우 리스트로 강제 페이지 이동
        if (recruit == null) {
            check.put("check", true);
            location = "/view/recruit/RecruitList";

            // recruit != null 이고 현재 비로그인 상태일 경우
        } else if (recruit != null && principal == null) {
            Member member = recruit.getMember();
            Company company = this.companyService.getData(member);
            model.addAttribute("recruit", recruit);
            model.addAttribute("company", company);
            location = "/view/recruit/RecruitDetail";

            // recruit != null 이고 현재 로그인 상태일 경우 (해당 회원이 해당 공고에 지원했는지 여부 체크하여 사용
        } else if (recruit != null && principal != null) {
            Member member = recruit.getMember();
            Company company = this.companyService.getData(member);
            String username = principal.getName();
            Member user = this.memberService.getMemberinfo(username);
            Apply apply = this.applyService.getapply(recruit, user);
            model.addAttribute("sort", member.getSort());
            model.addAttribute("apply", apply);
            model.addAttribute("recruit", recruit);
            model.addAttribute("company", company);

            location = "/view/recruit/RecruitDetail";
        }

        return new ModelAndView(location);
    }

    @GetMapping("/revise/{id}")
    public ModelAndView reviseRecruit(Model model, Map<String, Object> check, Principal principal,
            @PathVariable("id") Long id) {

        try {
            String username = principal.getName();
            model.addAttribute("username", username);
            Recruit recruit = this.recruitService.getRecruit(id);
            String location = "";
            if (recruit == null) {
                check.put("check", true);
                location = "/view/RecruitList";
            } else if (recruit != null) {
                model.addAttribute("recruit", recruit);

                // 연봉정보 (월급 혹은 연봉여부 및 화폐단위 자동 선택되게 하기 위해 해당 값 model 로 전송
                String salaryData = recruit.getSalary();
                char[] salaryChar = salaryData.toCharArray();
                String[] salaryString = new String[salaryChar.length];
                String period = salaryString[0].concat(salaryString[1]);
                String currency = salaryString[salaryString.length - 2].concat(salaryString[salaryString.length - 1]);

                model.addAttribute("period", period);
                model.addAttribute("currency", currency);
                location = "/view/ReviseRecruit";
            }
            return new ModelAndView(location);

        } catch (NullPointerException e) {
            check.put("check", true);
            return new ModelAndView("/view/Login");
        }
    }

}
