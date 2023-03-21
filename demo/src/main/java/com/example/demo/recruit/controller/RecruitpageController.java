package com.example.demo.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String recruitList(Model model) {
        List<Recruit> recruitList = this.recruitService.getRecruit();
        model.addAttribute("recruitList", recruitList);
        
        return "/view/recruit/RecruitList";
    }
}
