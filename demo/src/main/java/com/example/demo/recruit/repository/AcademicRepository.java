package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Resume;

public interface AcademicRepository extends JpaRepository<Academic, Long> {

    List<Academic> findById_resume(Resume id_resume);

    void deleteById_resume(Resume id_resume);

}
