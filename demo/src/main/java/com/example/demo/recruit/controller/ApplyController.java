package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.ApplyDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.ApplyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ApplyController {

    @Autowired
    private final ApplyService applyService;

    // 개인 회원의 채용공고 지원 내역을 조회하기 위해 사용
    @GetMapping("/apply/listbymember")
    public ResponseEntity<List<Apply>> getListByMember(@RequestParam(required = false) Member member) {
        try {
            List<Apply> applyList = new ArrayList<Apply>();
            applyList = applyService.getapply(member);
            return new ResponseEntity<>(applyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 기업 회원의 채용공고에 지원한 지원 정보를 조회하기 위해 사용
    @GetMapping("/apply/listbyrecruit")
    public ResponseEntity<List<Apply>> getListByRecruit(@RequestParam(required = false) Recruit recruit) {
        try {
            List<Apply> applyList = new ArrayList<Apply>();
            applyList = applyService.getapply(recruit);
            return new ResponseEntity<>(applyList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 지원 정보 개별 조회를 위해 사용
    @GetMapping("/apply/detail")
    public ResponseEntity<Apply> getApply(@RequestParam(required = false) Long id) {
        try {
            Apply apply = new Apply();
            apply = applyService.getapply(id);
            return new ResponseEntity<>(apply, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 개인 회원이 채용공고에 지원 시 해당 지원 정보를 저장하기 위해 사용
    @PostMapping("/apply/input")
    public ResponseEntity<Apply> inputData(@RequestBody ApplyDto applyDto) {
        try {
            Apply apply = applyService.inputData(applyDto);
            return new ResponseEntity<>(apply, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 지원 취소를 진행하기 위해 사용
    @DeleteMapping("/apply/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            applyService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
