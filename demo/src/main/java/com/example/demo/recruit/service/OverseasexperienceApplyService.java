package com.example.demo.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.OverseasexperienceApply;
import com.example.demo.recruit.repository.OverseasexperienceApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OverseasexperienceApplyService {

    @Autowired
    private final OverseasexperienceApplyRepository overseasexperienceApplyRepository;

    public void inputData(List<Overseasexperience> oeList, Apply apply) {
        for (int i = 0; i < oeList.size(); i++) {
            this.overseasexperienceApplyRepository.save(new OverseasexperienceApply(
                    apply,
                    oeList.get(i).getStart(),
                    oeList.get(i).getEnd(),
                    oeList.get(i).getStaying(),
                    oeList.get(i).getCountry(),
                    oeList.get(i).getDetail()));

        }
    }
    
    public List<OverseasexperienceApply> getList(Apply apply) {
        List<OverseasexperienceApply> oeApplyList = this.overseasexperienceApplyRepository.findAllByApply(apply);
        return oeApplyList;
    }
    
    public void deleteList(Apply apply) {
        this.overseasexperienceApplyRepository.deleteAllByApply(apply);
    }
}
