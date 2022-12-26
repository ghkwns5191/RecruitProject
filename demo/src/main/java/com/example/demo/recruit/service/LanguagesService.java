package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.LanguagesRepository;

@Service
public class LanguagesService {

    @Autowired
    private LanguagesRepository languagesRepository;

    public List<Languages> getlanguages(Resume id_resume) {
        List<Languages> languages = new ArrayList<Languages>();
        languagesRepository.findById_resume(id_resume).forEach(languages::add);
        return languages;
    }
    
    public Languages getlanguages(Long id_languages) {
        Optional<Languages> languagesData = languagesRepository.findById(id_languages);
        Languages languages = languagesData.get();
        return languages;
    }
}
