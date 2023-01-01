package com.example.demo.recruit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    Optional<Member> findByUsername(String member_username);
    
    Boolean existsByMember_username(String member_username);
    
    Boolean existsByMember_email(String member_email);
}
