package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.OverseasexperienceService;

@Controller
public class OverseasexperienceController {

    @Autowired
    private OverseasexperienceService overseasexperienceService;

    @GetMapping
    public ResponseEntity<List<Overseasexperience>> getList(@RequestParam(required = false) Resume id_resume) {
        try {
            List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
            overseasexperience = overseasexperienceService.getoverseasexperience(id_resume);
            return new ResponseEntity<>(overseasexperience, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<Overseasexperience> getOverseasexperience(@RequestParam(required = false) Long id_overseasexperience) {
        try {
            Overseasexperience overseasexperience = new Overseasexperience();
            overseasexperience = overseasexperienceService.getoverseasexperience(id_overseasexperience);
            return new ResponseEntity<>(overseasexperience, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
