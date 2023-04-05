package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.CareerApply;

public interface CareerApplyRepository extends JpaRepository<CareerApply, Long>{

    List<CareerApply> findAllByApply(Apply apply);

    void deleteAllByApply(Apply apply);
}
