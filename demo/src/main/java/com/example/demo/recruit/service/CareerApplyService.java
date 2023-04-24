package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    
    public List<CareerApply> getList(Apply apply) {
        List<CareerApply> careerApplyList = this.careerApplyRepository.findAllByApply(apply);
        
        return careerApplyList;
    }
    
    public void deleteList(Apply apply) {
        this.careerApplyRepository.deleteAllByApply(apply);
    }
    
    public List<Integer> getnumber(Page<Apply> applyList) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < applyList.toList().size(); i++) {
            List<CareerApply> careerApplyList = getList(applyList.toList().get(i));
            numbers.add(careerApplyList.size());
        }
        return numbers;
    }
}
