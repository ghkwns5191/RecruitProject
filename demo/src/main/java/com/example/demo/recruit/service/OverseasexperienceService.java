package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.OverseasexperienceDto;
import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.OverseasexperienceRepository;
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class OverseasexperienceService {

    @Autowired
    private OverseasexperienceRepository overseasexperienceRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;
    
    // 해당 이력서의 해외경험 리스트를 조회하는 코드
    public List<Overseasexperience> getoverseasexperience(Resume resume) {
        List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
        overseasexperienceRepository.findByResume(resume).forEach(overseasexperience::add);
        return overseasexperience;
    }
    
    // 해당 해외경험만 조회하는 코드
    public Overseasexperience getoverseasexperience(Long id_overseasexperience) {
        Optional<Overseasexperience> overseasexperienceData = overseasexperienceRepository.findById(id_overseasexperience);
        Overseasexperience overseasexperience = overseasexperienceData.get();
        return overseasexperience;
    }
    
    // 이력서 작성 시 해외경험을 입력받아 DB 에 저장하는 코드
    public Overseasexperience inputData(OverseasexperienceDto overseasexperienceDto) {
        Overseasexperience overseasexperience = this.overseasexperienceRepository.save(new Overseasexperience(
                overseasexperienceDto.getResume(),
                overseasexperienceDto.getOverseasexperience_start(),
                overseasexperienceDto.getOverseasexperience_end(),
                overseasexperienceDto.getOverseasexperience_staying(),
                overseasexperienceDto.getOverseasexperience_country(),
                overseasexperienceDto.getOverseasexperience_detail()
                ));
        return overseasexperience;
    }
    
    // DB 에 저장된 해외경험을 수정하는 코드
    public Overseasexperience inputData(Long id_overseasexperience, OverseasexperienceDto overseasexperienceDto) {
        Optional<Overseasexperience> overseasexperienceData = 
                this.overseasexperienceRepository.findById(id_overseasexperience);
        Overseasexperience overseasexperience = 
                overseasexperienceData.get();
        overseasexperience.setOverseasexperience_start(
                overseasexperienceDto.getOverseasexperience_start());
        overseasexperience.setOverseasexperience_end(
                overseasexperienceDto.getOverseasexperience_end());
        overseasexperience.setOverseasexperience_staying(
                overseasexperienceDto.getOverseasexperience_staying());
        overseasexperience.setOverseasexperience_country(
                overseasexperienceDto.getOverseasexperience_country());
        overseasexperience.setOverseasexperience_detail(
                overseasexperienceDto.getOverseasexperience_detail());
        this.overseasexperienceRepository.save(overseasexperience);
        return overseasexperience;
    }
    
    // DB 에 저당된 해외경험을 삭제하는 코드
    public void deleteData(Long id_overseasexperience) {
        this.overseasexperienceRepository.deleteById(id_overseasexperience);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
        this.overseasexperienceRepository.findByResume(resume).
        forEach(overseasexperience::add);
        this.overseasexperienceRepository.deleteAll(overseasexperience);
    }
}
