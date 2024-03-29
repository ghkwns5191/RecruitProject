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

import com.example.demo.recruit.dto.OverseasexperienceDto;
import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.OverseasexperienceService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/overseas")
@RequiredArgsConstructor
public class OverseasexperienceController {

    @Autowired
    private final OverseasexperienceService overseasexperienceService;
    
    @Autowired
    private final ResumeService resumeService;

    // 해당 이력성 조회 시 해외경험도 함께 조회하기 위해 사용
    @GetMapping("/list")
    public ResponseEntity<List<Overseasexperience>> getList(@RequestParam(required = false) Resume resume) {
        try {
            List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
            overseasexperience = overseasexperienceService.getoverseasexperience(resume);
            return new ResponseEntity<>(overseasexperience, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 해당 해외경험만 조회하기 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Overseasexperience> getOverseasexperience(@RequestParam(required = false) Long id) {
        try {
            Overseasexperience overseasexperience = new Overseasexperience();
            overseasexperience = overseasexperienceService.getoverseasexperience(id);
            return new ResponseEntity<>(overseasexperience, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 해외경험을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<List<Overseasexperience>> inputData(
            @RequestBody List<OverseasexperienceDto> overseasexperienceDtoList, Principal principal) {
        try {
            List<Overseasexperience> overseasexperienceList = overseasexperienceService
                    .inputData(overseasexperienceDtoList, principal);
            return new ResponseEntity<>(overseasexperienceList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 해외경험을 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<List<Overseasexperience>> reviseData(@PathVariable("id") Long id,
            @RequestBody List<OverseasexperienceDto> overseasexperienceDtoList) {
        try {
            Resume resume = this.resumeService.getResume(id);
            List<Overseasexperience> overseasexperienceList = this.overseasexperienceService.inputData(resume, overseasexperienceDtoList);
            return new ResponseEntity<>(overseasexperienceList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 해외경험을 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id_overseasexperience") Long id) {
        try {
            overseasexperienceService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<List<Overseasexperience>> getListbyResume(@PathVariable("id") Long id) {
    	try {
    		 Resume resume = this.resumeService.getResume(id);
    		 List<Overseasexperience> overseasexperienceList = this.overseasexperienceService.getoverseasexperience(resume);
    		 return new ResponseEntity<>(overseasexperienceList, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
