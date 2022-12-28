package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.ActivityDto;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.service.ActivityService;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // 이력서 조회 시 활동내용을 함께 조회하기 위해 사용
    @GetMapping
    public ResponseEntity<List<Activity>> getActivity(@RequestParam(required = false) Resume id_resume) {

        try {
            List<Activity> activityList = new ArrayList<Activity>();
            activityList = activityService.getactivity(id_resume);
            return new ResponseEntity<>(activityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 활동내용만 별도로 조회하기 위해 사용
    @GetMapping
    public ResponseEntity<Activity> getActivity(@RequestParam(required = false) Long id_activity) {
        try {
            Activity activity = new Activity();
            activity = activityService.getactivity(id_activity);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 이력서상 활동내용을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping
    public ResponseEntity<Activity> inputData(@RequestBody ActivityDto activityDto) {
        try {
            Activity activity = activityService.inputData(activityDto);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
