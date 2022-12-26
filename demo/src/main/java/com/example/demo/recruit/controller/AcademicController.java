package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.AcademicService;

@Controller
public class AcademicController {

    @Autowired
    public AcademicService academicService;

    @GetMapping
    public ResponseEntity<List<Academic>> academicList(@RequestParam(required = false) Resume id_resume) {
        try {
            List<Academic> acaList = new ArrayList<Academic>();
            acaList = academicService.getacademic(id_resume);
            return new ResponseEntity<>(acaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity<Academic> getacademic(@RequestParam(required = false) Long id_academic) {
        try {
            Academic academic = new Academic();
            academic = academicService.getacademic(id_academic);
            return new ResponseEntity<>(academic, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
