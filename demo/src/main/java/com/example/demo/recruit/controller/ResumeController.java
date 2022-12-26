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
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.ResumeService;

@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    
    @GetMapping
    public ResponseEntity<List<Resume>> getList(@RequestParam(required = false) Member id_member) {
        try {
            List<Resume> resume = new ArrayList<Resume>();
            resume = resumeService.getResume(id_member);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<Resume> getResume(@RequestParam(required = false) Long id_resume) {
        try {
            Resume resume = new Resume();
            resume = resumeService.getResume(id_resume);
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
