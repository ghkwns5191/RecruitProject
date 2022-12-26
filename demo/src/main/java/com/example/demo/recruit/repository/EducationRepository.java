package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Resume;

public interface EducationRepository extends JpaRepository<Education, Long> {

    List<Education> findById_resume(Resume id_resume);

}
