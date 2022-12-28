package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;
    
    // 회원의 이력서 정보를 불러오는 코드
    public List<Resume> getResume(Member id_member) {
        List<Resume> resume = new ArrayList<Resume>();
        resumeRepository.findById_member(id_member).forEach(resume::add);
        return resume;
    }

    // 해당 이력서 정보를 불러오는 코드
    public Resume getResume(Long id_resume) {
        Optional<Resume> resumeData = resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        return resume;
    }
    
    public Resume inputData(ResumeDto resumeDto) {
        Resume resume = this.resumeRepository.save(new Resume(
                resumeDto.getId_member(),
                resumeDto.getResume_photo(),
                resumeDto.getResume_cv(),
                resumeDto.getResume_openforheadhunter()));
        return resume;
    }
}
