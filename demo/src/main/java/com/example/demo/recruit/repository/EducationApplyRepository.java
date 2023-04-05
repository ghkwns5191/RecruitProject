package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.EducationApply;

public interface EducationApplyRepository extends JpaRepository<EducationApply, Long> {

    List<EducationApply> findAllByApply(Apply apply);
    
    void deleteAllByApply(Apply apply);

}
