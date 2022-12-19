package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
