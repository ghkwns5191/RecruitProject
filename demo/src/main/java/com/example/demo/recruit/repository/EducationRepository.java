package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {

}