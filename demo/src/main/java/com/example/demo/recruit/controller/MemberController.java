package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getList() {
        try {
            List<Member> memberList = new ArrayList<Member>();
            memberList = memberService.getMember();
            return new ResponseEntity<>(memberList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Member> getMember(@RequestParam(required = false) Long id_member) {
        try {
            Member member = new Member();
            memberService.getMember(id_member);
            return new ResponseEntity<>(member, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
