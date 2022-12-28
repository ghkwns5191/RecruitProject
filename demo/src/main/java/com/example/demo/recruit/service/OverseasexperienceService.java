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

@Service
public class OverseasexperienceService {

    @Autowired
    private OverseasexperienceRepository overseasexperienceRepository;
    
    // 해당 이력서의 해외경험 리스트를 조회하는 코드
    public List<Overseasexperience> getoverseasexperience(Resume id_resume) {
        List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
        overseasexperienceRepository.findById_resume(id_resume).forEach(overseasexperience::add);
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
                overseasexperienceDto.getId_resume(),
                overseasexperienceDto.getOverseasexperience_start(),
                overseasexperienceDto.getOverseasexperience_end(),
                overseasexperienceDto.getOverseasexperience_staying(),
                overseasexperienceDto.getOverseasexperience_country(),
                overseasexperienceDto.getOverseasexperience_detail()
                ));
        return overseasexperience;
    }
}
