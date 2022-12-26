package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Activity;
import com.example.demo.recruit.entity.Resume;

public interface ActivityRepository extends JpaRepository<Activity, Long>{

    List<Activity> findById_Resume(Resume id_resume);

}
