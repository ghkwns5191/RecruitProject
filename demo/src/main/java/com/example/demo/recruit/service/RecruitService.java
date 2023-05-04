package com.example.demo.recruit.service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.RecruitDto;
import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitService {

    @Autowired
    private final RecruitRepository recruitRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 전체 채용공고를 불러오는 코드 (페이징 적용)
    public Page<Recruit> getRecruit(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "registerdate"));
        Page<Recruit> recruit = this.recruitRepository.findAll(pageable);
        return recruit;
    }

    public List<Recruit> getRecruit() {
        List<Recruit> recruitList = this.recruitRepository.findAll();
        return recruitList;
    }

    // 전체 채용공고를 불러오는 코드 (페이징 적용) + 검색 결과
    public Page<Recruit> getRecruit(Pageable pageable, String searchKeyword) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "registerdate"));
        Page<Recruit> recruit = this.recruitRepository.findByTitleContaining(searchKeyword, pageable);
        return recruit;
    }

    // 5개 최신 공고만 불러오는 코드
    public List<Recruit> getRecruit5() {
        List<Recruit> recruit = new ArrayList<Recruit>();
        recruitRepository.findTop5ByOrderByRegisterdateDesc().forEach(recruit::add);
        return recruit;
    }

    // 해당 회원이 작성한 채용공고를 불러오는 코드
    public List<Recruit> getRecruit(Member member) {
        List<Recruit> recruit = new ArrayList<Recruit>();
        recruitRepository.findByMember(member).forEach(recruit::add);
        return recruit;
    }
    
    public List<Recruit> getRecruit5(Member member) {
        List<Recruit> recruitList = this.recruitRepository.findTop5ByMemberOrderByRegisterdateDesc(member);
        return recruitList;
    }

    // 해당 채용공고만 불러오는 코드
    public Recruit getRecruit(Long id) {
        Optional<Recruit> recruitData = this.recruitRepository.findById(id);
        Recruit recruit = recruitData.get();
        return recruit;
    }

    // 입력받은 채용공고를 DB 에 저장하는 코드
    public Recruit inputData(RecruitDto recruitDto, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        if (member.getSort().equals("company")) {
            Recruit recruit = this.recruitRepository.save(new Recruit(
                    member,
                    recruitDto.getTitle(),
                    member.getName(),
                    LocalDate.now(),
                    null,
                    recruitDto.getCareer(),
                    recruitDto.getSalary(),
                    recruitDto.getWorkingdays(),
                    recruitDto.getDetail(),
                    recruitDto.getPhonenumber(),
                    recruitDto.getAttn(),
                    recruitDto.getDeadline()));
            return recruit;
        } else {
            return null;
        }

    }

    // DB 에 저장된 채용공고를 수정하는 코드
    public Recruit inputData(Long id, RecruitDto recruitDto) {
        Optional<Recruit> recruitData = this.recruitRepository.findById(id);
        Recruit recruit = recruitData.get();
        recruit.setTitle(recruitDto.getTitle());
        recruit.setWriter(recruit.getWriter());
        recruit.setModifydate(LocalDate.now());
        recruit.setCareer(recruitDto.getCareer());
        recruit.setSalary(recruitDto.getSalary());
        recruit.setWorkingdays(recruitDto.getWorkingdays());
        recruit.setDetail(recruitDto.getDetail());
        recruit.setPhonenumber(recruitDto.getPhonenumber());
        recruit.setAttn(recruitDto.getAttn());
        this.recruitRepository.save(recruit);
        return recruit;
    }

    // DB 에 저장된 채용공고를 삭제하는 코드
    public void deleteData(Long id) {
        this.recruitRepository.deleteById(id);
    }
    
    public List<Recruit> getList(List<Apply> applyList) {
        List<Recruit> recruitList = new ArrayList<>();
        for (int i = 0; i < applyList.size(); i++) {
            Recruit recruit = applyList.get(i).getRecruit();
            recruitList.add(recruit);
        }
        
        return recruitList;
    }

}
