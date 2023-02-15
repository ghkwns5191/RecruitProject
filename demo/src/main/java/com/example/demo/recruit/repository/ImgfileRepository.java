package com.example.demo.recruit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Resume;

@Repository
public interface ImgfileRepository extends JpaRepository<Imgfile, Long>{

    Imgfile findByResume(Resume resume);

}
