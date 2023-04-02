package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findByMember(Member Member);

    List<Apply> findByRecruit(Recruit Recruit);

    Apply findByRecruitAndMember(Recruit recruit, Member member);

}
