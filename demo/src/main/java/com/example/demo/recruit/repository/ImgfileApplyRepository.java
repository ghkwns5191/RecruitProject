package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.ImgfileApply;

public interface ImgfileApplyRepository extends JpaRepository<ImgfileApply, Long> {

    ImgfileApply findByApply(Apply apply);

    void deleteByApply(Apply apply);

}
