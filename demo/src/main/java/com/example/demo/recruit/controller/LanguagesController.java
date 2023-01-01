package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.LanguagesDto;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.LanguagesService;

@Controller
public class LanguagesController {

    @Autowired
    private LanguagesService languagesService;
    
    // 해당 이력서 조회 시 어학사항 함께 조회하기 위해 사용
    @GetMapping("/languages/list")
    public ResponseEntity<List<Languages>> getList(@RequestParam(required = false) Resume id_resume) {
        try {
            List<Languages> languagesList = new ArrayList<Languages>();
            languagesList = languagesService.getlanguages(id_resume);
            return new ResponseEntity<>(languagesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 해당 어학사항만 조회하기 위해 사용
    @GetMapping("/languages/detail")
    public ResponseEntity<Languages> getLanguages(@RequestParam(required = false) Long id_languages) {
        try {
            Languages languages = new Languages();
            languages = languagesService.getlanguages(id_languages);
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 어학사항을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/languages/input")
    public ResponseEntity<Languages> inputData(@RequestBody LanguagesDto languagesDto) {
        try {
            Languages languages = languagesService.inputData(languagesDto);
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 어학사항을 수정하기 위해 사용
    @PutMapping("/languages/revise")
    public ResponseEntity<Languages> reviseData(@PathVariable("id_languages") Long id_languages, @RequestBody LanguagesDto languagesDto) {
        try {
            Languages languages = languagesService.inputData(id_languages, languagesDto);
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 어학사항을 삭제하기 위해 사용
    @DeleteMapping("/languages/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id_languages") Long id_languages) {
        try {
            languagesService.deleteData(id_languages);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
