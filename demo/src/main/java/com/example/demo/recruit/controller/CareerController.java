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

import com.example.demo.recruit.dto.CareerDto;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.CareerService;

@Controller
public class CareerController {

    @Autowired
    private CareerService careerService;

    @GetMapping
    public ResponseEntity<List<Career>> careerList(@RequestParam(required = false) Resume id_resume) {
        try {
            List<Career> careerList = new ArrayList<Career>();
            careerList = careerService.getcareer(id_resume);
            return new ResponseEntity<>(careerList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity<Career> getCareer(@RequestParam(required = false) Long id_career) {
        try {
            Career career = new Career();
            career = careerService.getcareer(id_career);
            return new ResponseEntity<>(career, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Career> inputData(@RequestBody CareerDto careerDto) {
        try {
            Career career = careerService.inputData(careerDto);
            return new ResponseEntity<>(career, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
