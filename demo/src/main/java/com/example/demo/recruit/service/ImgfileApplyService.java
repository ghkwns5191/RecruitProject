package com.example.demo.recruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.ImgfileApply;
import com.example.demo.recruit.repository.ImgfileApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImgfileApplyService {

    @Autowired
    private final ImgfileApplyRepository imgfileApplyRepository;

    public void inputData(Imgfile imgfile, Apply apply) {
        this.imgfileApplyRepository.save(new ImgfileApply(
                imgfile.getImgname(),
                imgfile.getOriname(),
                imgfile.getImgurl(),
                apply));
    }
    
    public ImgfileApply getData(Apply apply) {
        ImgfileApply imgfileApply = this.imgfileApplyRepository.findByApply(apply);
        return imgfileApply;
    }
    
    public void deleteData(Apply apply) {
        this.imgfileApplyRepository.deleteByApply(apply);
    }
}
