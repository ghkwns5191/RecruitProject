package com.example.demo.recruit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.MemberDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.ERole;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    @Autowired
    private final MemberRepository memberRepository;

    // 모든 회원 리스트를 조회하는 코드
    public List<Member> getMember() {
        List<Member> member = new ArrayList<Member>();
        memberRepository.findAll().forEach(member::add);
        return member;
    }

    // 해당 아이디의 상세 정보를 조회하는 코드
    public Member getMember(Long id) {
        Optional<Member> memberData = memberRepository.findById(id);
        Member member = memberData.get();
        return member;
    }

    public Member getMemberinfo(String username) {
        Member member = this.memberRepository.findByUsername(username);
        return member;
    }

    // 가입계정의 아이디 중복확인하는 코드
    private void validationUsername(MemberDto member) {
        Member findUsername = this.memberRepository.findByUsername(member.getUsername());

        if (findUsername != null) {
            System.out.println("아이디 중복 발생");
            ;

        }

    }

    // 가입계정의 전화번호 중복확인하는 코드
    private void validationPhone(MemberDto member) {

        Optional<Member> findPhone = this.memberRepository.findByPhone(member.getPhone());

        if (findPhone != null) {
            throw new IllegalStateException("이미 사용중인 전화번호 입니다.");
        }
    }

    // 가입계정의 이메일 중복확인하는 코드
    private void validationEmail(MemberDto member) {

        Optional<Member> findEmail = this.memberRepository.findByEmail(member.getEmail());
        if (findEmail != null) {
            throw new IllegalStateException("이미 사용중인 이메일 입니다.");
        }
    }

    public Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        // 계정정보 중복여부 Validation
//        validationUsername(memberDto);

//        validationPhone(memberDto);
//        validationEmail(memberDto);

        // 입력받은 정보 member 변수에 저장.
        Member member = new Member();
        member.setSort(memberDto.getSort());
        member.setUsername(memberDto.getUsername());
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setName(memberDto.getName());
        member.setPhone(memberDto.getPhone());
        member.setEmail(memberDto.getEmail());
        member.setBirthday(memberDto.getBirthday());
        member.setAddress(memberDto.getAddress());
        member.setRegisterdate(LocalDate.now());
        member.setRole(ERole.USER);

        // member 변수 내용 DB 에 저장.
        this.memberRepository.save(member);
        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = this.memberRepository.findByUsername(username);

        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder().username(member.getUsername()).password(member.getPassword())
                .roles(member.getRole().toString()).build();
    }

    // 관리자 계정 생성코드
    public Member createAdmin(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        // 계정정보 중복여부 Validation
//        validationUsername(memberDto);
//        validationPhone(memberDto);
//        validationEmail(memberDto);

        // 입력받은 정보 member 변수에 저장.
        Member member = new Member();
        member.setSort(memberDto.getSort());
        member.setUsername(memberDto.getUsername());
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setName(memberDto.getName());
        member.setPhone(memberDto.getPhone());
        member.setEmail(memberDto.getEmail());
        member.setBirthday(memberDto.getBirthday());
        member.setAddress(memberDto.getAddress());
        member.setRegisterdate(LocalDate.now());
        member.setRole(ERole.ADMIN);

        // member 변수 내용 DB 에 저장.
        this.memberRepository.save(member);
        return member;
    }

    public Member getMember(String memberData) {
        Member member = memberRepository.findByUsername(memberData);

        return member;
    }

    public boolean checkUsername(String username) throws NoSuchElementException {
        Member member = memberRepository.findByUsername(username);

        if (member != null) {
            String msg = "이미 사용중인 아이디입니다.";
            System.out.println(username + "은 " + msg);
            return true;
        } else {
            String msg = "사용 가능한 아이디입니다.";
            System.out.println(username + "은 " + msg);
            return false;
        }
    }
    
    public Member reviseMember(Member member, MemberDto memberDto) {
        member.setName(memberDto.getName());
        member.setPhone(memberDto.getPhone());
        member.setEmail(memberDto.getEmail());
        member.setBirthday(memberDto.getBirthday());
        member.setAddress(memberDto.getAddress());               
        return member;
    }
    
    // 회원 강제탈퇴 시킬 때 사용 예정
    public void deleteMember(Long id) {
        this.memberRepository.deleteById(id);
    }
    
    // 회원 자진 탈퇴에 사용 예정
    public void deleteMember(String username) {
        this.memberRepository.deleteByUsername(username);
        
    }
    
    public List<Member> getMemberList(List<Apply> applyList) {
        List<Member> memberList = new ArrayList<>();
        for (int i = 0; i < applyList.size(); i++) {
            Member member = applyList.get(i).getMember();
            memberList.add(member);
        }
        
        return memberList;
    }

}
