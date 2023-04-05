package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.OverseasexperienceApply;

public interface OverseasexperienceApplyRepository extends JpaRepository<OverseasexperienceApply, Long> {

    List<OverseasexperienceApply> findAllByApply(Apply apply);
    
    void deleteAllByApply(Apply apply);

}
