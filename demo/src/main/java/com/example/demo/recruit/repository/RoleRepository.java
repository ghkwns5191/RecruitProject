package com.example.demo.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
