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

@Service
public class LanguagesService {

    @Autowired
    private LanguagesRepository languagesRepository;

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
}
