package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMember() {
        List<Member> member = new ArrayList<Member>();
        memberRepository.findAll().forEach(member::add);
        return member;
    }

    public Member getMember(Long id_member) {
        Optional<Member> memberData = memberRepository.findById(id_member);
        Member member = memberData.get();
        return member;
    }
}
