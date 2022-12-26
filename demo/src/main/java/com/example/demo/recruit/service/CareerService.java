package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.CareerRepository;

@Service
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;

    public List<Career> getcareer(Resume id_resume) {
        List<Career> career = new ArrayList<Career>();
        careerRepository.findById_resume(id_resume).forEach(career::add);
        return career;
    }

    public Career getcareer(Long id_career) {
        Optional<Career> careerData = careerRepository.findById(id_career);
        Career career = careerData.get();
        return career;
    }
}
