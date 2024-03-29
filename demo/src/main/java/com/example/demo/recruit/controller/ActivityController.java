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

import com.example.demo.recruit.dto.ActivityDto;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.ActivityService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private final ActivityService activityService;
    
    @Autowired
    private final ResumeService resumeService;

    // 이력서 조회 시 활동내용을 함께 조회하기 위해 사용
    @GetMapping("/list")
    public ResponseEntity<List<Activity>> getActivity(@RequestParam(required = false) Resume resume) {

        try {
            List<Activity> activityList = new ArrayList<Activity>();
            activityList = activityService.getactivity(resume);
            return new ResponseEntity<>(activityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 활동내용만 별도로 조회하기 위해 사용
    @GetMapping("/detail")
    public ResponseEntity<Activity> getActivity(@RequestParam(required = false) Long id) {
        try {
            Activity activity = new Activity();
            activity = activityService.getactivity(id);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 활동내용을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping("/input")
    public ResponseEntity<List<Activity>> inputData(@RequestBody List<ActivityDto> activityDtoList, Principal principal) {
        try {
            List<Activity> activityList = activityService.inputData(activityDtoList, principal);
            return new ResponseEntity<>(activityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 활동내용을 수정하기 위해 사용
    @PutMapping("/revise/{id}")
    public ResponseEntity<List<Activity>> reviseData(@PathVariable("id") Long id, @RequestBody List<ActivityDto> activityDtoList) {
        try {
            Resume resume = this.resumeService.getResume(id);
            List<Activity> activityList = activityService.inputData(resume, activityDtoList);
            return new ResponseEntity<>(activityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 활동내용을 삭제하기 위해 사용
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            activityService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<List<Activity>> getList(@PathVariable("id") Long id) {
    	try {
    		Resume resume = this.resumeService.getResume(id);
    		List<Activity> activityList = this.activityService.getactivity(resume);
    		return new ResponseEntity<>(activityList, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    		
    	}
    }
}
