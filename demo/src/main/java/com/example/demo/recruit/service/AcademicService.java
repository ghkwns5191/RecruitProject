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
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class AcademicService {

    @Autowired
    public AcademicRepository academicRepository;
    
    @Autowired
    public ResumeRepository resumeRepository;

    // 이력서에 해당하는 학력정보를 불러내는 코드
    public List<Academic> getacademic(Resume id_resume) {
        List<Academic> academic = new ArrayList<Academic>();
        this.academicRepository.findByResume(id_resume).forEach(academic::add);

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
                academicDto.getResume(),
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

    // DB 학력정보를 불러와서 수정 후 DB 에 다시 저장하는 코드
    public Academic inputData(Long id_academic, AcademicDto academicDto) {
        Optional<Academic> academicData = this.academicRepository.findById(id_academic);
        Academic academic = academicData.get();
        academic.setAcademic_start(academicDto.getAcademic_start());
        academic.setAcademic_end(academicDto.getAcademic_end());
        academic.setAcademic_studying(academicDto.getAcademic_studying());
        academic.setAcademic_type(academicDto.getAcademic_type());
        academic.setAcademic_name(academicDto.getAcademic_name());
        academic.setAcademic_major(academicDto.getAcademic_major());
        academic.setAcademic_grade(academicDto.getAcademic_grade());
        academic.setAcademic_gradefull(academicDto.getAcademic_gradefull());
        academic.setAcademic_detail(academicDto.getAcademic_detail());
        this.academicRepository.save(academic);
        return academic;

    }
    
    // DB 에 저장된 학력정보를 삭제하는 코드
    public void deleteData(Long id_academic) {
        this.academicRepository.deleteById(id_academic);
    }
    
    // 이력서 삭제할때 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Academic> academic = new ArrayList<Academic>();
        this.academicRepository.findByResume(resume).forEach(academic::add);
        this.academicRepository.deleteAll(academic);
    }

}
