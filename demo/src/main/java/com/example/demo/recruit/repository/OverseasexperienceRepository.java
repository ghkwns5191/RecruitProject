package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Resume;

public interface OverseasexperienceRepository extends JpaRepository <Overseasexperience, Long> {

    List<Overseasexperience> findById_resume(Resume id_resume);

}
