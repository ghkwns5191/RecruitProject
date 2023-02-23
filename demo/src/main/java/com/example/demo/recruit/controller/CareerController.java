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

import com.example.demo.recruit.dto.CareerDto;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.CareerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/career")
public class CareerController {

    @Autowired
    private final CareerService careerService;

    // 이력서 조회 시 경력사항을 조회하기 위해 사용
    @GetMapping("/list")
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
    @GetMapping("/detail")
    public ResponseEntity<Career> getCareer(@RequestParam(required = false) Long id) {
        try {
            Career career = new Career();
            career = careerService.getcareer(id);
            return new ResponseEntity<>(career, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 경력사항을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<List<Career>> inputData(@RequestBody List<CareerDto> careerDtoList, Principal principal) {
        try {
            List<Career> careerList = careerService.inputData(careerDtoList, principal);
            return new ResponseEntity<>(careerList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 경력사항을 수정하기 위해 사용
    @PutMapping("/revise")
    public ResponseEntity<Career> reviseData(@PathVariable("id") Long id, @RequestBody CareerDto careerDto) {
        try {
            Career career = careerService.inputData(id, careerDto);
            return new ResponseEntity<>(career, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 경력사항을 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            careerService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
