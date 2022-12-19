package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {

}
