package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Certificate;
import com.example.demo.recruit.entity.Resume;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    List<Certificate> findById_resume(Resume id_resume);

}
