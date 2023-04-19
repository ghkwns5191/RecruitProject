package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.CertificateApply;
import com.example.demo.recruit.repository.CertificateApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificateApplyService {

    @Autowired
    private final CertificateApplyRepository certificateApplyRepository;

    public void inputData(List<Certificate> certificateList, Apply apply) {
        for (int i = 0; i < certificateList.size(); i++) {
            this.certificateApplyRepository.save(new CertificateApply(
                    apply,
                    certificateList.get(i).getAchievedate(),
                    certificateList.get(i).getName(),
                    certificateList.get(i).getGrade(),
                    certificateList.get(i).getAchievefrom(),
                    certificateList.get(i).getCertificatenumber()));
        }
    }

    public List<CertificateApply> getList(Apply apply) {
        List<CertificateApply> certificateApplyList = this.certificateApplyRepository.findAllByApply(apply);
        return certificateApplyList;
    }
    
    public void deleteList(Apply apply) {
        this.certificateApplyRepository.deleteAllByApply(apply);
    }
    
    public List<Integer> getnumber(List<Apply> applyList) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < applyList.size(); i++) {
            List<CertificateApply> certificateApplyList = getList(applyList.get(i));
            numbers.add(certificateApplyList.size());
        }
        return numbers;
        
    }
}
