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
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;

    // 해당 이력서의 자격증 내역을 조회하는 코드
    public List<Certificate> getcertificate(Resume id_resume) {
        List<Certificate> certificate = new ArrayList<Certificate>();
        certificateRepository.findById_resume(id_resume).forEach(certificate::add);
        return certificate;
    }
    
    // 해당 자격증 내역만 조회하는 코드
    public Certificate getcertificate(Long id_certificate) {
        Optional<Certificate> certificateData = certificateRepository.findById(id_certificate);
        Certificate certificate = certificateData.get();
        return certificate;
    }
    
    // 자격증 내역을 입력받아 DB 에 저장하는 코드
    public Certificate inputData(CertificateDto certificateDto) {
        Certificate certificate = this.certificateRepository.save(new Certificate(
                certificateDto.getId_resume(), 
                certificateDto.getCertificate_achievedate(), 
                certificateDto.getCertificate_name(), 
                certificateDto.getCertificate_grade(), 
                certificateDto.getCertificate_achievefrom(), 
                certificateDto.getCertificate_certificatenumber()));
        return certificate;
    }
    
    // 자격증 내역을 수정하는 코드
    public Certificate inputData(Long id_certificate, CertificateDto certificateDto) {
        Optional<Certificate> certificateData = this.certificateRepository.findById(id_certificate);
        Certificate certificate = certificateData.get();
        certificate.setCertificate_achievedate(certificateDto.getCertificate_achievedate());
        certificate.setCertificate_name(certificateDto.getCertificate_name());
        certificate.setCertificate_grade(certificateDto.getCertificate_grade());
        certificate.setCertificate_achievefrom(certificateDto.getCertificate_achievefrom());
        certificate.setCertificate_certificatenumber(certificateDto.getCertificate_certificatenumber());
        this.certificateRepository.save(certificate);
        return certificate;
    }
    
    // 자격증 내역을 삭제하는 코드
    public void deleteData(Long id_certificate) {
        this.certificateRepository.deleteById(id_certificate);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Certificate> certificate = new ArrayList<Certificate>();
        this.certificateRepository.findById_resume(resume).forEach(certificate::add);
        this.certificateRepository.deleteAll(certificate);
    }
}
