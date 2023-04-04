package com.example.demo.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.CareerApply;
import com.example.demo.recruit.repository.CareerApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CareerApplyService {

    @Autowired
    private final CareerApplyRepository careerApplyRepository;

    public void inputData(List<Career> careerList, Apply apply) {
        for (int i = 0; i < careerList.size(); i++) {
            this.careerApplyRepository.save(new CareerApply(
                    apply,
                    careerList.get(i).getStart(),
                    careerList.get(i).getEnd(),
                    careerList.get(i).getWorking(),
                    careerList.get(i).getCompanyname(),
                    careerList.get(i).getRanks(),
                    careerList.get(i).getSalary(),
                    careerList.get(i).getJobduty(),
                    careerList.get(i).getDetail()));
        }
    }
}
