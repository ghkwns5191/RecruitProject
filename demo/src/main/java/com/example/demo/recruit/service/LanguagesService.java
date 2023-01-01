package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.LanguagesDto;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.LanguagesRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguagesService {

    @Autowired
    private final LanguagesRepository languagesRepository;
    
    @Autowired
    private final ResumeRepository resumeRepository;

    // 이력서 조회 시 어학사항 함께 조회하는 코드
    public List<Languages> getlanguages(Resume resume) {
        List<Languages> languages = new ArrayList<Languages>();
        languagesRepository.findByResume(resume).forEach(languages::add);
        return languages;
    }
    
    // 해당 어학사항만 조회하는 코드
    public Languages getlanguages(Long id) {
        Optional<Languages> languagesData = languagesRepository.findById(id);
        Languages languages = languagesData.get();
        return languages;
    }
    
    // 어학사항을 입력받아 DB 에 저장하는 코드
    public Languages inputData(LanguagesDto languagesDto) {
        Languages languages = this.languagesRepository.save(new Languages(
                languagesDto.getResume(),
                languagesDto.getLeveltalking(),
                languagesDto.getLevelwriting(),
                languagesDto.getTest(),
                languagesDto.getScore(),
                languagesDto.getAchievedate(),
                languagesDto.getCertificatenumber()));
        return languages;
    }
    
    // DB 에 저장된 어학사항을 수정하는 코드
    public Languages inputData(Long id, LanguagesDto languagesDto) {
        Optional<Languages> languagesData = this.languagesRepository.findById(id);
        Languages languages = languagesData.get();
        languages.setLeveltalking(languagesDto.getLeveltalking());
        languages.setLevelwriting(languagesDto.getLevelwriting());
        languages.setTest(languagesDto.getTest());
        languages.setScore(languagesDto.getScore());
        languages.setAchievedate(languagesDto.getAchievedate());
        languages.setCertificatenumber(languagesDto.getCertificatenumber());
        this.languagesRepository.save(languages);
        return languages;
    }
    
    // DB 에 저장된 어학사항을 삭제하는 코드
    public void deleteData(Long id) {
        this.languagesRepository.deleteById(id);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Languages> languages = new ArrayList<Languages>();
        this.languagesRepository.findByResume(resume).forEach(languages::add);
        this.languagesRepository.deleteAll(languages);
    }
}
