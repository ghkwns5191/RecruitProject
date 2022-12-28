package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.AcademicDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.AcademicRepository;

@Service
public class AcademicService {

    @Autowired
    public AcademicRepository academicRepository;
    
    //이력서에 해당하는 학력정보를 불러내는 코드
    public List<Academic> getacademic(Resume id_resume) {
        List<Academic> academic = new ArrayList<Academic>();
        this.academicRepository.findById_resume(id_resume).forEach(academic::add);

        return academic;
    }

    // 해당 학력정보만 불러내는 코드
    public Academic getacademic(Long id_academic) {
        Optional<Academic> academicData = this.academicRepository.findById(id_academic);
        Academic academic = academicData.get();
        return academic;
    }

    // 학력정보를 입력받아 DB 에 저장하는 코드
    public Academic inputData(AcademicDto academicDto) {
        Academic academic = this.academicRepository.save(new Academic(
                academicDto.getId_resume(),
                academicDto.getAcademic_start(),
                academicDto.getAcademic_end(),
                academicDto.getAcademic_studying(),
                academicDto.getAcademic_type(),
                academicDto.getAcademic_name(),
                academicDto.getAcademic_major(),
                academicDto.getAcademic_grade(),
                academicDto.getAcademic_gradefull(),
                academicDto.getAcademic_detail()));
        return academic;
    }

}
