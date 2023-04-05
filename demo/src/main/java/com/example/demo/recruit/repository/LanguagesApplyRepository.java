package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.LanguagesApply;

public interface LanguagesApplyRepository extends JpaRepository<LanguagesApply, Long>{

    List<LanguagesApply> findAllByApply(Apply apply);
    
    void deleteAllByApply(Apply apply);

}
