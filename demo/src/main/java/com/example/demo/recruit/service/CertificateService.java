package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CertificateDto;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.CertificateRepository;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public List<Certificate> getcertificate(Resume id_resume) {
        List<Certificate> certificate = new ArrayList<Certificate>();
        certificateRepository.findById_resume(id_resume).forEach(certificate::add);
        return certificate;
    }
    
    public Certificate getcertificate(Long id_certificate) {
        Optional<Certificate> certificateData = certificateRepository.findById(id_certificate);
        Certificate certificate = certificateData.get();
        return certificate;
    }
    
    public Certificate inputData(CertificateDto certificateDto) {
        Certificate certificate = this.certificateRepository.save(new Certificate(certificateDto.getId_resume(), certificateDto.getCertificate_achievedate(), certificateDto.getCertificate_name(), certificateDto.getCertificate_grade(), certificateDto.getCertificate_achievefrom(), certificateDto.getCertificate_certificatenumber()));
        return certificate;
    }
}
