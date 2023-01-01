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

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;

    // 해당 이력서 조회 시 교육내용을 함께 조회하기 위한 코드
    public List<Education> geteducation(Resume resume) {
        List<Education> education = new ArrayList<Education>();
        educationRepository.findByResume(resume).forEach(education::add);
        return education;
    }

    // 해당 교육내용만 조회하는 코드
    public Education geteducation(Long id_education) {
        Optional<Education> educationData = educationRepository.findById(id_education);
        Education education = educationData.get();
        return education;
    }

    // 교육내용을 입력받아 DB 에 저장하는 코드
    public Education inputData(EducationDto educationDto) {
        Education education = this.educationRepository.save(new Education(
                educationDto.getResume(),
                educationDto.getEducation_start(),
                educationDto.getEducation_end(),
                educationDto.getEducation_title(),
                educationDto.getEducation_holdby(),
                educationDto.getEducation_detail()));
        return education;
    }
    
    // DB 에 저장된 교육내용을 수정하는 코드
    public Education inputData(Long id_education, EducationDto educationDto) {
        Optional<Education> educationData = this.educationRepository.findById(id_education);
        Education education = educationData.get();
        education.setEducation_start(educationDto.getEducation_start());
        education.setEducation_end(educationDto.getEducation_end());
        education.setEducation_title(educationDto.getEducation_title());
        education.setEducation_holdby(educationDto.getEducation_holdby());
        education.setEducation_detail(educationDto.getEducation_detail());
        this.educationRepository.save(education);
        return education;
    }
    
    // DB 에 저장된 교육내용을 삭제하는 코드
    public void deleteData(Long id_education) {
        this.educationRepository.deleteById(id_education);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Education> education = new ArrayList<Education>();
        this.educationRepository.findByResume(resume).forEach(education::add);
        this.educationRepository.deleteAll(education);
    }
}
