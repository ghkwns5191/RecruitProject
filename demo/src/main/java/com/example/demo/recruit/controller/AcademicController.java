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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.AcademicDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AcademicController {

    @Autowired
    public final AcademicService academicService;

    //이력서 조회 시 학력정보를 함께 조회하기 위해 사용
    @GetMapping("/academic/list")
    public ResponseEntity<List<Academic>> academicList(@RequestParam(required = false) Resume id_resume) {
        try {
            List<Academic> acaList = new ArrayList<Academic>();
            acaList = academicService.getacademic(id_resume);
            return new ResponseEntity<>(acaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 학력정보만 별도로 조회하기 위해 사용
    @GetMapping("/academic/detail")
    public ResponseEntity<Academic> getacademic(@RequestParam(required = false) Long id_academic) {
        try {
            Academic academic = new Academic();
            academic = academicService.getacademic(id_academic);
            return new ResponseEntity<>(academic, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 학력정보를 입력받아 저장하기 위해 사용
    @PostMapping("/academic/input")
    public ResponseEntity<Academic> inputData(@RequestBody AcademicDto academicDto) {
        try {
            Academic academic = academicService.inputData(academicDto);
            return new ResponseEntity<>(academic, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 학력정보를 수정하기 위해 사용
    @PutMapping("/academic/revise")
    public ResponseEntity<Academic> reviseData(@PathVariable("id_academic") Long id_academic, @RequestBody AcademicDto academicDto) {
        try {
            Academic academic = academicService.inputData(id_academic, academicDto);
            return new ResponseEntity<>(academic, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 학력정보를 삭제하기 위해 사용
    @DeleteMapping("/academic/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id_academic") Long id_academic) {
        try {
            academicService.deleteData(id_academic);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
