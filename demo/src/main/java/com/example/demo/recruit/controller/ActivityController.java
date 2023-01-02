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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.ActivityDto;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.ActivityService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ActivityController {

    @Autowired
    private final ActivityService activityService;

    // 이력서 조회 시 활동내용을 함께 조회하기 위해 사용
    @GetMapping("/activity/list")
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
    @GetMapping("/activity/detail")
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
    @PostMapping("/activity/input")
    public ResponseEntity<Activity> inputData(@RequestBody ActivityDto activityDto) {
        try {
            Activity activity = activityService.inputData(activityDto);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 활동내용을 수정하기 위해 사용
    @PutMapping("/activity/revise")
    public ResponseEntity<Activity> reviseData(@PathVariable("id") Long id, @RequestBody ActivityDto activityDto) {
        try {
            Activity activity = activityService.inputData(id, activityDto);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 이력서상 활동내용을 삭제하기 위해 사용
    @DeleteMapping("/activity/delete")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") Long id) {
        try {
            activityService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
