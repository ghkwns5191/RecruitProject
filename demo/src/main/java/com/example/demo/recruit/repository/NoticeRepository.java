package com.example.demo.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    List<Notice> findTop5ByOrderByRegisterdateDesc();

}
