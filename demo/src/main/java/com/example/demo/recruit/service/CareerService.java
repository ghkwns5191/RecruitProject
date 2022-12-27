package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CareerDto;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.CareerRepository;

@Service
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;

    public List<Career> getcareer(Resume id_resume) {
        List<Career> career = new ArrayList<Career>();
        this.careerRepository.findById_resume(id_resume).forEach(career::add);
        return career;
    }

    public Career getcareer(Long id_career) {
        Optional<Career> careerData = this.careerRepository.findById(id_career);
        Career career = careerData.get();
        return career;
    }
    
    public Career inputData(CareerDto careerDto) {
        Career career = this.careerRepository.save(new Career(careerDto.getId_resume(), careerDto.getCareer_start(), careerDto.getCareer_end(), careerDto.getCareer_working(), careerDto.getCareer_companyname(), careerDto.getCareer_rank(), careerDto.getCareer_salary(), careerDto.getCareer_jobduty(), careerDto.getCareer_detail()));
        return career;
    }
}
