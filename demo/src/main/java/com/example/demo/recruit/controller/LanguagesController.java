package com.example.demo.recruit.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.LanguagesDto;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.LanguagesService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguagesController {

    @Autowired
    private final LanguagesService languagesService;
    
    @Autowired
    private final ResumeService resumeService;
    
    // 해당 이력서 조회 시 어학사항 함께 조회하기 위해 사용
    @GetMapping("/list")
    public ResponseEntity<List<Languages>> getList(@RequestParam(required = false) Resume resume) {
        try {
            List<Languages> languagesList = new ArrayList<Languages>();
            languagesList = languagesService.getlanguages(resume);
            return new ResponseEntity<>(languagesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 해당 어학사항만 조회하기 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Languages> getLanguages(@RequestParam(required = false) Long id) {
        try {
            Languages languages = new Languages();
            languages = languagesService.getlanguages(id);
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 어학사항을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<List<Languages>> inputData(@RequestBody List<LanguagesDto> languagesDtoList, Principal principal) {
        try {
            List<Languages> languagesList = languagesService.inputData(languagesDtoList, principal);
            return new ResponseEntity<>(languagesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 어학사항을 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<List<Languages>> reviseData(@PathVariable("id") Long id, @RequestBody List<LanguagesDto> languagesDtoList) {
        try {
            Resume resume = this.resumeService.getResume(id);
            List<Languages> languagesList = languagesService.inputData(resume, languagesDtoList);
            return new ResponseEntity<>(languagesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 어학사항을 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id_languages") Long id) {
        try {
            languagesService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<List<Languages>> getListbyResume(@PathVariable("id") Long id) {
    	try {
    		Resume resume = this.resumeService.getResume(id);
    		List<Languages> languagesList = this.languagesService.getlanguages(resume);
    		return new ResponseEntity<>(languagesList, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
