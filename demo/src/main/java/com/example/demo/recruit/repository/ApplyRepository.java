package com.example.demo.recruit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    Page<Apply> findAllByMember(Member Member, Pageable pageable);
    
    List<Apply> findAllByMember(Member member);

    Page<Apply> findAllByRecruit(Recruit Recruit, Pageable pageable);
    
    List<Apply> findAllByRecruit(Recruit recruit);

    Apply findByRecruitAndMember(Recruit recruit, Member member);

    List<Apply> findTop5ByMemberOrderByApplydateDesc(Member member);

	List<Apply> findAllByApplydate(LocalDate dateinfo);

	List<Apply> findTop10ByOrderByApplydate();

}
