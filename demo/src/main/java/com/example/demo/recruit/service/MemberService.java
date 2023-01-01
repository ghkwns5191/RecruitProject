package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public List<Member> getMember() {
        List<Member> member = new ArrayList<Member>();
        memberRepository.findAll().forEach(member::add);
        return member;
    }

    public Member getMember(Long id) {
        Optional<Member> memberData = memberRepository.findById(id);
        Member member = memberData.get();
        return member;
    }
}
