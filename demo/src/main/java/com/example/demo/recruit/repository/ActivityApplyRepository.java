package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.ActivityApply;
import com.example.demo.recruit.entity.Apply;

public interface ActivityApplyRepository extends JpaRepository<ActivityApply, Long> {

    List<ActivityApply> findAllByApply(Apply apply);

    void deleteAllByApply(Apply apply);

}
