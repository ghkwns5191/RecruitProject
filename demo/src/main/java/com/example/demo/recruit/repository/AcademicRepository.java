package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Academic;

public interface AcademicRepository extends JpaRepository<Academic, Long>{

}