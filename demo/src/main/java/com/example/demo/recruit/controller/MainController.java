package com.example.demo.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {

        return "/view/Home";

    }

    @GetMapping("/login")
    public String loginPage() {
        return "/view/Login";
    }

    @GetMapping("/join")
    public String JoinPage() {
        return "/view/Join";
    }
}
