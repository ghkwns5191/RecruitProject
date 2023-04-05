package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.CertificateApply;

public interface CertificateApplyRepository extends JpaRepository<CertificateApply, Long>{

    List<CertificateApply> findAllByApply(Apply apply);
    
    void deleteAllByApply(Apply apply);

}
