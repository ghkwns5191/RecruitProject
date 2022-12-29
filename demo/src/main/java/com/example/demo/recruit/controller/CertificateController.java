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

import com.example.demo.recruit.dto.CertificateDto;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.CertificateService;

@Controller
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // 이력서 조회 시 자격증 정보를 함께 조회하기 위해 사용
    @GetMapping
    public ResponseEntity<List<Certificate>> getList(@RequestParam(required = false) Resume id_resume) {

        try {
            List<Certificate> certificateList = new ArrayList<Certificate>();
            certificateList = certificateService.getcertificate(id_resume);
            return new ResponseEntity<>(certificateList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 해당 자격증 정보만 조회하기 위해 사용
    @GetMapping
    public ResponseEntity<Certificate> getCertificate(@RequestParam(required = false) Long id_certificate) {
        try {
            Certificate certificate = new Certificate();
            certificate = certificateService.getcertificate(id_certificate);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 자격증 내역을 입력받아 저정하기 위해 사용
    @PostMapping
    public ResponseEntity<Certificate> inputData(@RequestBody CertificateDto certificateDto) {
        try {
            Certificate certificate = certificateService.inputData(certificateDto);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 자격증 내역을 수정하기 위해 사용
    @PutMapping
    public ResponseEntity<Certificate> reviseData(@PathVariable("id_certificate") Long id_certificate, CertificateDto certificateDto) {
        try {
            Certificate certificate = certificateService.inputData(id_certificate, certificateDto);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 자격증 내역을 삭제하기 위해 사용
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id_certificate") Long id_certificate) {
        try {
            certificateService.deleteData(id_certificate);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
