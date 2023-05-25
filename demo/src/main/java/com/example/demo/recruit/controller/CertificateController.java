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

import com.example.demo.recruit.dto.CertificateDto;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.CertificateService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/certificate")
@RequiredArgsConstructor
public class CertificateController {

    @Autowired
    private final CertificateService certificateService;
    
    @Autowired
    private final ResumeService resumeService;

    // 이력서 조회 시 자격증 정보를 함께 조회하기 위해 사용
    @GetMapping("/list")
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
    @GetMapping("/detail")
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
    @PostMapping("/input")
    public ResponseEntity<List<Certificate>> inputData(@RequestBody List<CertificateDto> certificateDtoList, Principal principal) {
        try {
            List<Certificate> certificateList = certificateService.inputData(certificateDtoList, principal);
            return new ResponseEntity<>(certificateList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 자격증 내역을 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<List<Certificate>> reviseData(@PathVariable("id") Long id, List<CertificateDto> certificateDtoList) {
        try {
            Resume resume = this.resumeService.getResume(id);
            List<Certificate> certificateList = certificateService.inputData(resume, certificateDtoList);
            return new ResponseEntity<>(certificateList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 자격증 내역을 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            certificateService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<List<Certificate>> getcerties(@PathVariable("id") Long id) {
    	try {
    		Resume resume = this.resumeService.getResume(id);
    		List<Certificate> certificateList = this.certificateService.getcertificate(resume);
    		return new ResponseEntity<>(certificateList, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
