package com.example.demo.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.ActivityApply;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.repository.ActivityApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityApplyService {

    @Autowired
    private final ActivityApplyRepository activityApplyRepository;

    public void inputData(List<Activity> activityList, Apply apply) {
        for (int i = 0; i < activityList.size(); i++) {
            this.activityApplyRepository.save(new ActivityApply(
                    apply,
                    activityList.get(i).getStart(),
                    activityList.get(i).getEnd(),
                    activityList.get(i).getTitle(),
                    activityList.get(i).getHoldby(),
                    activityList.get(i).getDetail()));
        }
    }
}
