package com.example.demo.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.AcademicApply;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.repository.AcademicApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcademicApplyService {

    @Autowired
    private final AcademicApplyRepository academicApplyRepository;

    // Controller 에서 받아온 academicList 값을 순차적으로 academicApplyRepository 에 저장.
    public void inputData(List<Academic> academicList, Apply apply) {

        for (int i = 0; i < academicList.size(); i++) {
            this.academicApplyRepository.save(new AcademicApply(
                    apply,
                    academicList.get(i).getStart(),
                    academicList.get(i).getEnd(),
                    academicList.get(i).getStudying(),
                    academicList.get(i).getType(),
                    academicList.get(i).getName(),
                    academicList.get(i).getMajor(),
                    academicList.get(i).getGrade(),
                    academicList.get(i).getGradefull(),
                    academicList.get(i).getDetail()));
        }
    }
}
