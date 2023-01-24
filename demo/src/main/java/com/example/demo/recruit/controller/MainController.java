package com.example.demo.recruit.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Principal principal, Model model) {
		if (principal == null) {
			model.addAttribute("username", null);
			return "view/Home";
		} else {
			model.addAttribute("username", principal.getName());
			return "view/Home";
		}
	}

}
