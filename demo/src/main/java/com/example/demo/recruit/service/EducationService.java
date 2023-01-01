package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.EducationDto;
import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.EducationRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationService {

    @Autowired
    private final EducationRepository educationRepository;
    
    @Autowired
    private final ResumeRepository resumeRepository;

    // 해당 이력서 조회 시 교육내용을 함께 조회하기 위한 코드
    public List<Education> geteducation(Resume resume) {
        List<Education> education = new ArrayList<Education>();
        educationRepository.findByResume(resume).forEach(education::add);
        return education;
    }

    // 해당 교육내용만 조회하는 코드
    public Education geteducation(Long id) {
        Optional<Education> educationData = educationRepository.findById(id);
        Education education = educationData.get();
        return education;
    }

    // 교육내용을 입력받아 DB 에 저장하는 코드
    public Education inputData(EducationDto educationDto) {
        Education education = this.educationRepository.save(new Education(
                educationDto.getResume(),
                educationDto.getStart(),
                educationDto.getEnd(),
                educationDto.getTitle(),
                educationDto.getHoldby(),
                educationDto.getDetail()));
        return education;
    }
    
    // DB 에 저장된 교육내용을 수정하는 코드
    public Education inputData(Long id, EducationDto educationDto) {
        Optional<Education> educationData = this.educationRepository.findById(id);
        Education education = educationData.get();
        education.setStart(educationDto.getStart());
        education.setEnd(educationDto.getEnd());
        education.setTitle(educationDto.getTitle());
        education.setHoldby(educationDto.getHoldby());
        education.setDetail(educationDto.getDetail());
        this.educationRepository.save(education);
        return education;
    }
    
    // DB 에 저장된 교육내용을 삭제하는 코드
    public void deleteData(Long id) {
        this.educationRepository.deleteById(id);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Education> education = new ArrayList<Education>();
        this.educationRepository.findByResume(resume).forEach(education::add);
        this.educationRepository.deleteAll(education);
    }
}
