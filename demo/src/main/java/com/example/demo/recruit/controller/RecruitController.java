package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.RecruitDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.RecruitService;

@Controller
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    // 채용공고 리스트를 조회하기 위해 사용
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
    
    // 기업 회원이 작성한 채용공고만 조회하기 위해 사용
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
    
    // 채용공고 단수 조회를 위해 사용
    @GetMapping
    public ResponseEntity<Recruit> getData(@RequestParam(required = false) Long id_recruit) {
        try {
            Recruit recruit = recruitService.getRecruit(id_recruit);
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 채용공고 내용을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping
    public ResponseEntity<Recruit> inputData(@RequestBody RecruitDto recruitDto) {
        try {
            Recruit recruit = recruitService.inputData(recruitDto);
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
