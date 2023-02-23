package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CertificateDto;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.CertificateRepository;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificateService {

    @Autowired
    private final CertificateRepository certificateRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 해당 이력서의 자격증 내역을 조회하는 코드
    public List<Certificate> getcertificate(Resume resume) {
        List<Certificate> certificate = new ArrayList<Certificate>();
        certificateRepository.findByResume(resume).forEach(certificate::add);
        return certificate;
    }

    // 해당 자격증 내역만 조회하는 코드
    public Certificate getcertificate(Long id) {
        Optional<Certificate> certificateData = certificateRepository.findById(id);
        Certificate certificate = certificateData.get();
        return certificate;
    }

    // 자격증 내역을 입력받아 DB 에 저장하는 코드
    public List<Certificate> inputData(List<CertificateDto> certificateDtoList, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Certificate> certificateList = new ArrayList<>();
        for (int i = 0; i < certificateDtoList.size(); i++) {
            CertificateDto certificateDto = certificateDtoList.get(i);
            Certificate certificate = this.certificateRepository.save(new Certificate(
                    resume,
                    certificateDto.getAchievedate(),
                    certificateDto.getName(),
                    certificateDto.getGrade(),
                    certificateDto.getAchievefrom(),
                    certificateDto.getCertificatenumber()));
            certificateList.add(certificate);
        }
        return certificateList;
    }

    // 자격증 내역을 수정하는 코드
    public Certificate inputData(Long id, CertificateDto certificateDto) {
        Optional<Certificate> certificateData = this.certificateRepository.findById(id);
        Certificate certificate = certificateData.get();
        certificate.setAchievedate(certificateDto.getAchievedate());
        certificate.setName(certificateDto.getName());
        certificate.setGrade(certificateDto.getGrade());
        certificate.setAchievefrom(certificateDto.getAchievefrom());
        certificate.setCertificatenumber(certificateDto.getCertificatenumber());
        this.certificateRepository.save(certificate);
        return certificate;
    }

    // 자격증 내역을 삭제하는 코드
    public void deleteData(Long id) {
        this.certificateRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Certificate> certificate = new ArrayList<Certificate>();
        this.certificateRepository.findByResume(resume).forEach(certificate::add);
        this.certificateRepository.deleteAll(certificate);
    }
}
