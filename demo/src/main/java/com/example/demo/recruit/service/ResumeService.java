package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;
    
    public List<Resume> getResume(Member id_member) {
        List<Resume> resume = new ArrayList<Resume>();
        resumeRepository.findById_member(id_member).forEach(resume::add);
        return resume;
    }
    
    public Resume getResume(Long id_resume) {
        Optional<Resume> resumeData = resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        return resume;
    }
}
