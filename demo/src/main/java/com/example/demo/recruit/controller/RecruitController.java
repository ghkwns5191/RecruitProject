package com.example.demo.recruit.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.RecruitDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.service.RecruitService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/recruit")
@RequiredArgsConstructor
public class RecruitController {

    @Autowired
    private final RecruitService recruitService;

    // 채용공고 리스트를 조회하기 위해 사용
    @GetMapping("/list")
    public ResponseEntity<List<Recruit>> getList() {
        try {
            List<Recruit> recruit = new ArrayList<Recruit>();
            recruit = recruitService.getRecruit();
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/list/represent")
    public ResponseEntity<List<Recruit>> get5() {
        try {
            List<Recruit> recruit = new ArrayList<Recruit>();      
            recruit = recruitService.getRecruit();
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 기업 회원이 작성한 채용공고만 조회하기 위해 사용
    @GetMapping("/listbymember")
    public ResponseEntity<List<Recruit>> getList(@RequestParam(required = false) Member member) {
        try {
            List<Recruit> recruit = new ArrayList<Recruit>();
            recruit = recruitService.getRecruit(member);
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 채용공고 단수 조회를 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Recruit> getData(@RequestParam(required = false) Long id) {
        try {
            Recruit recruit = recruitService.getRecruit(id);
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 채용공고 내용을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<Recruit> inputData(@RequestBody RecruitDto recruitDto, Principal principal) {
        try {
            Recruit recruit = recruitService.inputData(recruitDto, principal);
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 채용공고를 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<Recruit> reviseData(@PathVariable("id") Long id, @RequestBody RecruitDto recruitDto) {
        try {
            Recruit recruit = recruitService.inputData(id, recruitDto);
            return new ResponseEntity<>(recruit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 채용공고를 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            recruitService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
