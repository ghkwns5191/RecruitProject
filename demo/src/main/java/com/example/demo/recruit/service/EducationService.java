package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.EducationRepository;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> geteducation(Resume id_resume) {
        List<Education> education = new ArrayList<Education>();
        educationRepository.findById_resume(id_resume).forEach(education::add);
        return education;
    }
    
    public Education geteducation(Long id_education) {
        Optional<Education> educationData = educationRepository.findById(id_education);
        Education education = educationData.get();
        return education;
    }
}
