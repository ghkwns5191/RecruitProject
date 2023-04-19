package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.LanguagesApply;
import com.example.demo.recruit.repository.LanguagesApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguagesApplyService {

    @Autowired
    private final LanguagesApplyRepository languagesApplyRepository;

    public void inputData(List<Languages> languagesList, Apply apply) {
        for (int i = 0; i < languagesList.size(); i++) {
            this.languagesApplyRepository.save(new LanguagesApply(
                    apply,
                    languagesList.get(i).getLanguages(),
                    languagesList.get(i).getLeveltalking(),
                    languagesList.get(i).getLevelwriting(),
                    languagesList.get(i).getTest(),
                    languagesList.get(i).getScore(),
                    languagesList.get(i).getAchievedate(),
                    languagesList.get(i).getCertificatenumber()));
        }
    }
    
    public List<LanguagesApply> getList(Apply apply) {
        List<LanguagesApply> languagesApplyList = this.languagesApplyRepository.findAllByApply(apply);
        return languagesApplyList;
    }
    
    public void deleteList(Apply apply) {
        this.languagesApplyRepository.deleteAllByApply(apply);
    }
    
    public List<Integer> getnumber(List<Apply> applyList) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < applyList.size(); i++) {
            List<LanguagesApply> languagesApplyList = getList(applyList.get(i));
            numbers.add(languagesApplyList.size());
        }
        return numbers;
    }
}
