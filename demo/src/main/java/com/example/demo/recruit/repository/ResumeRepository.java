package com.example.demo.recruit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Resume findByMember(Member member);

}
