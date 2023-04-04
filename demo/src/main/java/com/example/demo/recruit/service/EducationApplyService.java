package com.example.demo.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.EducationApply;
import com.example.demo.recruit.repository.EducationApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationApplyService {

    @Autowired
    private final EducationApplyRepository educationApplyRepository;

    public void inputData(List<Education> educationList, Apply apply) {
        for (int i = 0; i < educationList.size(); i++) {
            this.educationApplyRepository.save(new EducationApply(
                    apply,
                    educationList.get(i).getStart(),
                    educationList.get(i).getEnd(),
                    educationList.get(i).getTitle(),
                    educationList.get(i).getHoldby(),
                    educationList.get(i).getDetail()));
        }
    }
}
