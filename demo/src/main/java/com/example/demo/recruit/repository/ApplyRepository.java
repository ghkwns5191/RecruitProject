package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findById_member(Member id_member);

    List<Apply> findById_recruit(Recruit id_recruit);

}
