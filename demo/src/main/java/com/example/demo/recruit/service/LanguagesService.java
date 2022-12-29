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

@Service
public class LanguagesService {

    @Autowired
    private LanguagesRepository languagesRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;

    // 이력서 조회 시 어학사항 함께 조회하는 코드
    public List<Languages> getlanguages(Resume id_resume) {
        List<Languages> languages = new ArrayList<Languages>();
        languagesRepository.findById_resume(id_resume).forEach(languages::add);
        return languages;
    }
    
    // 해당 어학사항만 조회하는 코드
    public Languages getlanguages(Long id_languages) {
        Optional<Languages> languagesData = languagesRepository.findById(id_languages);
        Languages languages = languagesData.get();
        return languages;
    }
    
    // 어학사항을 입력받아 DB 에 저장하는 코드
    public Languages inputData(LanguagesDto languagesDto) {
        Languages languages = this.languagesRepository.save(new Languages(
                languagesDto.getId_resume(),
                languagesDto.getLanguages_leveltalking(),
                languagesDto.getLanguages_levelwriting(),
                languagesDto.getLanguages_test(),
                languagesDto.getLanguages_score(),
                languagesDto.getLanguages_achievedate(),
                languagesDto.getLanguages_certificatenumber()));
        return languages;
    }
    
    // DB 에 저장된 어학사항을 수정하는 코드
    public Languages inputData(Long id_languages, LanguagesDto languagesDto) {
        Optional<Languages> languagesData = this.languagesRepository.findById(id_languages);
        Languages languages = languagesData.get();
        languages.setLanguages_leveltalking(languagesDto.getLanguages_leveltalking());
        languages.setLanguages_levelwriting(languagesDto.getLanguages_levelwriting());
        languages.setLanguages_test(languagesDto.getLanguages_test());
        languages.setLanguages_score(languagesDto.getLanguages_score());
        languages.setLanguages_achievedate(languagesDto.getLanguages_achievedate());
        languages.setLanguages_certificatenumber(languagesDto.getLanguages_certificatenumber());
        this.languagesRepository.save(languages);
        return languages;
    }
    
    // DB 에 저장된 어학사항을 삭제하는 코드
    public void deleteData(Long id_languages) {
        this.languagesRepository.deleteById(id_languages);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Languages> languages = new ArrayList<Languages>();
        this.languagesRepository.findById_resume(resume).forEach(languages::add);
        this.languagesRepository.deleteAll(languages);
    }
}
