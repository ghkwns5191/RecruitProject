package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.LanguagesService;

@Controller
public class LanguagesController {

    @Autowired
    private LanguagesService languagesService;
    
    @GetMapping
    public ResponseEntity<List<Languages>> getList(@RequestParam(required = false) Resume id_resume) {
        try {
            List<Languages> languagesList = new ArrayList<Languages>();
            languagesList = languagesService.getlanguages(id_resume);
            return new ResponseEntity<>(languagesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<Languages> getLanguages(@RequestParam(required = false) Long id_languages) {
        try {
            Languages languages = new Languages();
            languages = languagesService.getlanguages(id_languages);
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
