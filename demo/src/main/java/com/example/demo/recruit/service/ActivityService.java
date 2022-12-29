package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.ActivityDto;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ActivityRepository;
import com.example.demo.recruit.repository.ResumeRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;
    
    //이력서에 해당하는 활동내용 불러내는 코드
    public List<Activity> getactivity(Resume id_resume) {
        List<Activity> activitylist = new ArrayList<Activity>();
        this.activityRepository.findById_Resume(id_resume).forEach(activitylist::add);
        return activitylist;

    }
    
    //해당 화동내용만 불러내는 코드
    public Activity getactivity(Long id_activity) {
        Optional<Activity> activityData = this.activityRepository.findById(id_activity);
        Activity activity = activityData.get();
        return activity;
    }

    //활동내용을 입력받아 DB에 저장하는 코드
    public Activity inputData(ActivityDto activityDto) {
        Activity activity = this.activityRepository.save(new Activity(
                activityDto.getId_resume(),
                activityDto.getActivity_start(),
                activityDto.getActivity_end(),
                activityDto.getActivity_title(),
                activityDto.getActivity_holdby(),
                activityDto.getActivity_detail()));
        return activity;
    }
    
    // DB 에 저장된 활동내용을 수정하여 저장하는 코드
    public Activity inputData(Long id_activity, ActivityDto activityDto) {
        Optional<Activity> activityData = this.activityRepository.findById(id_activity);
        Activity activity = activityData.get();
        activity.setActivity_start(activityDto.getActivity_start());
        activity.setActivity_end(activityDto.getActivity_end());
        activity.setActivity_title(activityDto.getActivity_title());
        activity.setActivity_holdby(activityDto.getActivity_holdby());
        activity.setActivity_detail(activityDto.getActivity_detail());
        this.activityRepository.save(activity);
        return activity;
    }
    
    // DB 에 저장된 활동내용을 삭제하는 코드
    public void deleteData(Long id_activity) {
        this.activityRepository.deleteById(id_activity);
    }
    
    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id_resume) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id_resume);
        Resume resume = resumeData.get();
        List<Activity> activitylist = new ArrayList<Activity>();
        this.activityRepository.findById_Resume(resume).forEach(activitylist::add);
        this.activityRepository.deleteAll(activitylist);
    }
}
