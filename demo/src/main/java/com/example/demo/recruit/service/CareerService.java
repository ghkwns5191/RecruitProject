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
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;

    // 해당 이력서의 경력사항을 불러오는 코드
    public List<Career> getcareer(Resume id_resume) {
        List<Career> career = new ArrayList<Career>();
        this.careerRepository.findById_resume(id_resume).forEach(career::add);
        return career;
    }

    // 해당 경력사항만 불러오는 코드
    public Career getcareer(Long id_career) {
        Optional<Career> careerData = this.careerRepository.findById(id_career);
        Career career = careerData.get();
        return career;
    }
    
    // 경력사항을 입력받아 DB 에 저장하는 코드
    public Career inputData(CareerDto careerDto) {
        Career career = this.careerRepository.save(new Career(
                careerDto.getId_resume(), 
                careerDto.getCareer_start(), 
                careerDto.getCareer_end(), 
                careerDto.getCareer_working(), 
                careerDto.getCareer_companyname(), 
                careerDto.getCareer_rank(), 
                careerDto.getCareer_salary(), 
                careerDto.getCareer_jobduty(), 
                careerDto.getCareer_detail()));
        return career;
    }
    
    // 경력사항을 수정하여 DB 에 저장하는 코드
    public Career inputData(Long id_career, CareerDto careerDto) {
        Optional<Career> careerData = this.careerRepository.findById(id_career);
        Career career = careerData.get();
        career.setCareer_start(careerDto.getCareer_start());
        career.setCareer_end(careerDto.getCareer_end());
        career.setCareer_working(careerDto.getCareer_working());
        career.setCareer_companyname(careerDto.getCareer_companyname());
        career.setCareer_rank(careerDto.getCareer_rank());
        career.setCareer_salary(careerDto.getCareer_salary());
        career.setCareer_jobduty(careerDto.getCareer_jobduty());
        career.setCareer_detail(careerDto.getCareer_detail());
        this.careerRepository.save(career);
        return career;
    }
    
    // 경력사항 삭제하는 코드
    public void deleteData(Long id_career) {
        this.careerRepository.deleteById(id_career);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Career> career = new ArrayList<Career>();
        this.careerRepository.findById_resume(resume).forEach(career::add);
        this.careerRepository.deleteAll(career);
    }
}
