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
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.RecruitService;

@Controller
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @GetMapping
    public ResponseEntity<List<Recruit>> getList() {
        try {
            List<Recruit> recruit = new ArrayList<Recruit>();
            recruit = recruitService.getRecruit();
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Recruit>> getList(@RequestParam(required = false) Member id_member) {
        try {
            List<Recruit> recruit = new ArrayList<Recruit>();
            recruit = recruitService.getRecruit(id_member);
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
