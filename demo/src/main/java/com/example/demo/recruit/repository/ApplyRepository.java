package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

}