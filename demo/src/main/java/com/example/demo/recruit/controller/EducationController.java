package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.EducationService;

@Controller
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping
    public ResponseEntity<List<Education>> getList(@RequestParam(required = false) Resume id_resume) {

        try {
            List<Education> educationList = new ArrayList<Education>();
            educationList = educationService.geteducation(id_resume);
            return new ResponseEntity<>(educationList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<Education> getEducaction(@RequestParam(required = false) Long id_education) {
        try {
            Education education = new Education();
            education = educationService.geteducation(id_education);
            return new ResponseEntity<>(education, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
