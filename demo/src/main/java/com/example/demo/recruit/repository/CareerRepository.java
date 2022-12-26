package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Resume;

public interface CareerRepository extends JpaRepository<Career, Long> {

    List<Career> findById_resume(Resume id_resume);

}
