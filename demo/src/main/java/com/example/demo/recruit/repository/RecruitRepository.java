package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {

    List<Recruit> findByMember(Member member);

    List<Recruit> findTop5(Sort by);

    List<Recruit> findTop5ByOrderByRegisterdateDesc();

   

}
