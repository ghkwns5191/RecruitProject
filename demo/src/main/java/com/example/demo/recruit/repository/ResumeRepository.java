package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findById_member(Member id_member);

}
