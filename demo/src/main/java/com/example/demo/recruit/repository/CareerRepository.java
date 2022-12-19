package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {

}
