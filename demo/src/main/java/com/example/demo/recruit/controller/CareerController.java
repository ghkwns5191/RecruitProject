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

    // 이력서 조회 시 경력사항을 조회하기 위해 사용
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

    // 해당 경력사항만 조회하기 위해 사용
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

    // 이력서상 경력사항을 입력받아 DB 에 저장하기 위해 사용
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
