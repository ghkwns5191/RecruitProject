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
    public List<Certificate> inputData(Resume resume, List<CertificateDto> certificateDtoList) {
        List<Certificate> certificateList = this.certificateRepository.findAllByResume(resume);
        List<Certificate> certificateResult = new ArrayList<>();
        
        if (certificateDtoList.size() == certificateList.size()) {
            for (int i = 0; i < certificateDtoList.size(); i++) {
                certificateList.get(i).setAchievedate(certificateDtoList.get(i).getAchievedate());
                certificateList.get(i).setName(certificateDtoList.get(i).getName());
                certificateList.get(i).setGrade(certificateDtoList.get(i).getGrade());
                certificateList.get(i).setAchievefrom(certificateDtoList.get(i).getAchievefrom());
                certificateList.get(i).setCertificatenumber(certificateDtoList.get(i).getCertificatenumber());
                certificateResult.add(certificateList.get(i));
                this.certificateRepository.save(certificateList.get(i));
            }
            
        } else if (certificateDtoList.size() > certificateList.size()) {
            for (int i = 0; i < certificateList.size(); i++) {
                certificateList.get(i).setAchievedate(certificateDtoList.get(i).getAchievedate());
                certificateList.get(i).setName(certificateDtoList.get(i).getName());
                certificateList.get(i).setGrade(certificateDtoList.get(i).getGrade());
                certificateList.get(i).setAchievefrom(certificateDtoList.get(i).getAchievefrom());
                certificateList.get(i).setCertificatenumber(certificateDtoList.get(i).getCertificatenumber());
                certificateResult.add(certificateList.get(i));
                this.certificateRepository.save(certificateList.get(i));
            }
            
            for (int i = certificateList.size(); i < certificateDtoList.size(); i++) {
                Certificate certificate = this.certificateRepository.save(new Certificate(
                        resume,
                        certificateDtoList.get(i).getAchievedate(),
                        certificateDtoList.get(i).getName(),
                        certificateDtoList.get(i).getGrade(),
                        certificateDtoList.get(i).getAchievefrom(),
                        certificateDtoList.get(i).getCertificatenumber()
                        ));
                certificateResult.add(certificate);
            }
        } else if (certificateDtoList.size() < certificateList.size()) {
            for (int i = 0; i < certificateDtoList.size(); i++) {
                certificateList.get(i).setAchievedate(certificateDtoList.get(i).getAchievedate());
                certificateList.get(i).setName(certificateDtoList.get(i).getName());
                certificateList.get(i).setGrade(certificateDtoList.get(i).getGrade());
                certificateList.get(i).setAchievefrom(certificateDtoList.get(i).getAchievefrom());
                certificateList.get(i).setCertificatenumber(certificateDtoList.get(i).getCertificatenumber());
                certificateResult.add(certificateList.get(i));
                this.certificateRepository.save(certificateList.get(i));
            }
            
            for (int i = certificateDtoList.size(); i < certificateList.size(); i++) {
                this.certificateRepository.deleteById(certificateList.get(i).getId());
            }
        }
        
        return certificateResult;
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
