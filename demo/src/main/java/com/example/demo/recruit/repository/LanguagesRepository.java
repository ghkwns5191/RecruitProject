package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Resume;

public interface LanguagesRepository extends JpaRepository<Languages, Long> {

    List<Languages> findById_resume(Resume id_resume);

}
