package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.ActivityDto;
import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ActivityRepository;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

    @Autowired
    private final ActivityRepository activityRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 이력서에 해당하는 활동내용 불러내는 코드
    public List<Activity> getactivity(Resume resume) {
        List<Activity> activitylist = new ArrayList<Activity>();
        this.activityRepository.findByResume(resume).forEach(activitylist::add);
        return activitylist;

    }

    // 해당 화동내용만 불러내는 코드
    public Activity getactivity(Long id_activity) {
        Optional<Activity> activityData = this.activityRepository.findById(id_activity);
        Activity activity = activityData.get();
        return activity;
    }

    // 활동내용을 입력받아 DB에 저장하는 코드
    public List<Activity> inputData(List<ActivityDto> activityDtoList, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Activity> activityList = new ArrayList<>();
        for (int i = 0; i < activityDtoList.size(); i++) {
            ActivityDto activityDto = activityDtoList.get(i);
            Activity activity = this.activityRepository.save(new Activity(
                    resume,
                    activityDto.getStart(),
                    activityDto.getEnd(),
                    activityDto.getTitle(),
                    activityDto.getHoldby(),
                    activityDto.getDetail()));
            activityList.add(activity);
        }
        return activityList;
    }

    // DB 에 저장된 활동내용을 수정하여 저장하는 코드
    public Activity inputData(Long id_activity, ActivityDto activityDto) {
        Optional<Activity> activityData = this.activityRepository.findById(id_activity);
        Activity activity = activityData.get();
        activity.setStart(activityDto.getStart());
        activity.setEnd(activityDto.getEnd());
        activity.setTitle(activityDto.getTitle());
        activity.setHoldby(activityDto.getHoldby());
        activity.setDetail(activityDto.getDetail());
        this.activityRepository.save(activity);
        return activity;
    }

    // DB 에 저장된 활동내용을 삭제하는 코드
    public void deleteData(Long id) {
        this.activityRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Activity> activitylist = new ArrayList<Activity>();
        this.activityRepository.findByResume(resume).forEach(activitylist::add);
        this.activityRepository.deleteAll(activitylist);
    }
}
