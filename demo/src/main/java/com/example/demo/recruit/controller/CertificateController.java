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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.CertificateDto;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.CertificateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CertificateController {

    @Autowired
    private final CertificateService certificateService;

    // 이력서 조회 시 자격증 정보를 함께 조회하기 위해 사용
    @GetMapping("/certificate/list")
    public ResponseEntity<List<Certificate>> getList(@RequestParam(required = false) Resume resume) {

        try {
            List<Certificate> certificateList = new ArrayList<Certificate>();
            certificateList = certificateService.getcertificate(resume);
            return new ResponseEntity<>(certificateList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 해당 자격증 정보만 조회하기 위해 사용
    @GetMapping("/certificate/detail")
    public ResponseEntity<Certificate> getCertificate(@RequestParam(required = false) Long id) {
        try {
            Certificate certificate = new Certificate();
            certificate = certificateService.getcertificate(id);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 자격증 내역을 입력받아 저정하기 위해 사용
    @PostMapping("/certificate/input")
    public ResponseEntity<Certificate> inputData(@RequestBody CertificateDto certificateDto) {
        try {
            Certificate certificate = certificateService.inputData(certificateDto);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 자격증 내역을 수정하기 위해 사용
    @PutMapping("/certificate/revise")
    public ResponseEntity<Certificate> reviseData(@PathVariable("id") Long id, CertificateDto certificateDto) {
        try {
            Certificate certificate = certificateService.inputData(id, certificateDto);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 자격증 내역을 삭제하기 위해 사용
    @DeleteMapping("/certificate/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            certificateService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
