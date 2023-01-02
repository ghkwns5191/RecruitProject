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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CareerService {

    @Autowired
    private final CareerRepository careerRepository;
    
    @Autowired
    private final ResumeRepository resumeRepository;

    // 해당 이력서의 경력사항을 불러오는 코드
    public List<Career> getcareer(Resume resume) {
        List<Career> career = new ArrayList<Career>();
        this.careerRepository.findByResume(resume).forEach(career::add);
        return career;
    }

    // 해당 경력사항만 불러오는 코드
    public Career getcareer(Long id) {
        Optional<Career> careerData = this.careerRepository.findById(id);
        Career career = careerData.get();
        return career;
    }
    
    // 경력사항을 입력받아 DB 에 저장하는 코드
    public Career inputData(CareerDto careerDto) {
        Career career = this.careerRepository.save(new Career(
                careerDto.getResume(), 
                careerDto.getStart(), 
                careerDto.getEnd(), 
                careerDto.getWorking(), 
                careerDto.getCompanyname(), 
                careerDto.getRanks(), 
                careerDto.getSalary(), 
                careerDto.getJobduty(), 
                careerDto.getDetail()));
        return career;
    }
    
    // 경력사항을 수정하여 DB 에 저장하는 코드
    public Career inputData(Long id, CareerDto careerDto) {
        Optional<Career> careerData = this.careerRepository.findById(id);
        Career career = careerData.get();
        career.setStart(careerDto.getStart());
        career.setEnd(careerDto.getEnd());
        career.setWorking(careerDto.getWorking());
        career.setCompanyname(careerDto.getCompanyname());
        career.setRanks(careerDto.getRanks());
        career.setSalary(careerDto.getSalary());
        career.setJobduty(careerDto.getJobduty());
        career.setDetail(careerDto.getDetail());
        this.careerRepository.save(career);
        return career;
    }
    
    // 경력사항 삭제하는 코드
    public void deleteData(Long id) {
        this.careerRepository.deleteById(id);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Career> career = new ArrayList<Career>();
        this.careerRepository.findByResume(resume).forEach(career::add);
        this.careerRepository.deleteAll(career);
    }
}
