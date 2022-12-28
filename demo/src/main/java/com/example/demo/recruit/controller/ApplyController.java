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

import com.example.demo.recruit.dto.ApplyDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.ApplyService;

@Controller
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    // 개인 회원의 채용공고 지원 내역을 조회하기 위해 사용
    @GetMapping
    public ResponseEntity<List<Apply>> getListByMember(@RequestParam(required = false) Member id_member) {
        try {
            List<Apply> applyList = new ArrayList<Apply>();
            applyList = applyService.getapply(id_member);
            return new ResponseEntity<>(applyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 기업 회원의 채용공고에 지원한 지원 정보를 조회하기 위해 사용
    @GetMapping
    public ResponseEntity<List<Apply>> getListByRecruit(@RequestParam(required = false) Recruit id_recruit) {
        try {
            List<Apply> applyList = new ArrayList<Apply>();
            applyList = applyService.getapply(id_recruit);
            return new ResponseEntity<>(applyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 지원 정보 개별 조회를 위해 사용
    @GetMapping
    public ResponseEntity<Apply> getApply(@RequestParam(required = false) Long id_apply) {
        try {
            Apply apply = new Apply();
            apply = applyService.getapply(id_apply);
            return new ResponseEntity<>(apply, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 개인 회원이 채용공고에 지원 시 해당 지원 정보를 저장하기 위해 사용
    @PostMapping
    public ResponseEntity<Apply> inputData(@RequestBody ApplyDto applyDto) {
        try {
            Apply apply = applyService.inputData(applyDto);
            return new ResponseEntity<>(apply, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
