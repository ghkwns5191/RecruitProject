package com.example.demo.recruit.service;

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
    private final LanguagesApplyRepository langugagesApplyRepository;

    public void inputData(List<Languages> languagesList, Apply apply) {
        for (int i = 0; i < languagesList.size(); i++) {
            this.langugagesApplyRepository.save(new LanguagesApply(
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
}
