package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.CertificateService;

@Controller
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

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
}
