package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {

    List<Recruit> findById_member(Member id_member);

}
