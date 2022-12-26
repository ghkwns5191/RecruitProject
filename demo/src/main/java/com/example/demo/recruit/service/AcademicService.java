package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.AcademicRepository;

@Service
public class AcademicService {

    @Autowired
    public AcademicRepository academicRepository;

    public List<Academic> getacademic(Resume id_resume) {
        List<Academic> academic = new ArrayList<Academic>();
        academicRepository.findById_resume(id_resume).forEach(academic::add);

        return academic;
    }
    
    public Academic getacademic(Long id_academic) {
        Optional<Academic> academicData = academicRepository.findById(id_academic);
        Academic academic = academicData.get();
        return academic;
    }

}
