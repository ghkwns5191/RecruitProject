package com.example.demo.recruit.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recruit.dto.RecruitDto;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.RecruitService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/recruitpage")
@RequiredArgsConstructor
public class RecruitpageController {

    @Autowired
    private final RecruitService recruitService;

    @GetMapping("/list")
    public ModelAndView recruitList(Model model) {
        List<Recruit> recruitList = this.recruitService.getRecruit();
        model.addAttribute("recruitList", recruitList);

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

    @GetMapping("/detail/{id}")
    public ModelAndView recruitDetail(Model model, @PathVariable("id") Long id, Map<String, Object> check) {
        Recruit recruit = this.recruitService.getRecruit(id);
        String location = "";
        if (recruit == null) {
            check.put("check", true);
            location = "/view/RecruitList";
        } else if (recruit != null) {
            model.addAttribute("recruit", recruit);
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
                
                //연봉정보 (월급 혹은 연봉여부 및 화폐단위 자동 선택되게 하기 위해 해당 값 model 로 전송
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