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

import com.example.demo.recruit.dto.AcademicDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/academic")
public class AcademicController {

    @Autowired
    public final AcademicService academicService;
    
    @Autowired
    public final ResumeService resumeService;

    // 이력서 조회 시 학력정보를 함께 조회하기 위해 사용
    @GetMapping("/list")
    public ResponseEntity<List<Academic>> academicList(@RequestParam(required = false) Resume resume) {
        try {
            List<Academic> acaList = new ArrayList<Academic>();
            acaList = academicService.getacademic(resume);
            return new ResponseEntity<>(acaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 학력정보만 별도로 조회하기 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Academic> getacademic(@RequestParam(required = false) Long id) {
        try {
            Academic academic = new Academic();
            academic = academicService.getacademic(id);
            return new ResponseEntity<>(academic, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 학력정보를 입력받아 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<List<Academic>> inputData(@RequestBody List<AcademicDto> academicDtoList, Principal principal) {
        try {
            List<Academic> academicList = academicService.inputData(academicDtoList, principal);
            return new ResponseEntity<>(academicList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 학력정보를 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<List<Academic>> reviseData(@PathVariable("id") Long id, @RequestBody List<AcademicDto> academicDtoList) {
        try {
            Resume resume = this.resumeService.getResume(id);
            List<Academic> academicList = academicService.inputData(resume, academicDtoList);
            return new ResponseEntity<>(academicList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 학력정보를 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            academicService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서 id 기준으로 학력정보 조회하기
    @GetMapping("/get/{id}")
    public ResponseEntity<List<Academic>> getList(@PathVariable("id") Long id) {
    	try {
			Resume resume = this.resumeService.getResume(id);
			List<Academic> academicList = this.academicService.getacademic(resume);
			return new ResponseEntity<>(academicList, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
