package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getactivity(Resume id_resume) {
        List<Activity> activitylist = new ArrayList<Activity>();
        activityRepository.findById_Resume(id_resume).forEach(activitylist::add);
        return activitylist;

    }
    
    public Activity getactivity(Long id_activity) {
        Optional<Activity> activityData = activityRepository.findById(id_activity);
        Activity activity = activityData.get();
        return activity;
    }
}
