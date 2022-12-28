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

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    // 해당 이력서 조회 시 교육내용을 함께 조회하기 위한 코드
    public List<Education> geteducation(Resume id_resume) {
        List<Education> education = new ArrayList<Education>();
        educationRepository.findById_resume(id_resume).forEach(education::add);
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
                educationDto.getId_resume(),
                educationDto.getEducation_start(),
                educationDto.getEducation_end(),
                educationDto.getEducation_title(),
                educationDto.getEducation_holdby(),
                educationDto.getEducation_detail()));
        return education;
    }
}
