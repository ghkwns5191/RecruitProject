package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.OverseasexperienceRepository;

@Service
public class OverseasexperienceService {

    @Autowired
    private OverseasexperienceRepository overseasexperienceRepository;
    
    public List<Overseasexperience> getoverseasexperience(Resume id_resume) {
        List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
        overseasexperienceRepository.findById_resume(id_resume).forEach(overseasexperience::add);
        return overseasexperience;
    }
    
    public Overseasexperience getoverseasexperience(Long id_overseasexperience) {
        Optional<Overseasexperience> overseasexperienceData = overseasexperienceRepository.findById(id_overseasexperience);
        Overseasexperience overseasexperience = overseasexperienceData.get();
        return overseasexperience;
    }
}
