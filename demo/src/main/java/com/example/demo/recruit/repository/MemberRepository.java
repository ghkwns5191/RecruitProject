package com.example.demo.recruit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    Member findByUsername(String username);
    
    Boolean existsByUsername(String username);
    
    Boolean existsByEmail(String email);

    Optional<Member> findByPhone(String phone);

    Optional<Member> findByEmail(String email);
}
