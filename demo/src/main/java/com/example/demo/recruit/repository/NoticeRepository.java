package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
