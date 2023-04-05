package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.AcademicApply;
import com.example.demo.recruit.entity.Apply;

public interface AcademicApplyRepository extends JpaRepository<AcademicApply, Long> {

    Iterable<Academic> findByApply(Apply apply);

    List<AcademicApply> findAllByApply(Apply apply);

    void deleteAllByApply(Apply apply);

}
