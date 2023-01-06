package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.recruit.entity.Imgfile;

@Repository
public interface ImgfileRepository extends JpaRepository<Imgfile, Long>{

}
