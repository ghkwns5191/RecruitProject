package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
