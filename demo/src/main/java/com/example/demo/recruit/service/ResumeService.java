package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeService {

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 회원의 이력서 정보를 불러오는 코드
    public Resume getResume(Member member) {
        Resume resume = resumeRepository.findByMember(member);

        return resume;
    }

    // 해당 이력서 정보를 불러오는 코드
    public Resume getResume(Long id) {
        Optional<Resume> resumeData = resumeRepository.findById(id);
        Resume resume = resumeData.get();

        return resume;
    }

    // 이력서 정보를 DB 에 저장하는 코드
    public Resume inputData(ResumeDto resumeDto, Principal principal) throws Exception {

        // 이력서 등록
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = resumeRepository.save(new Resume(
                member,
                resumeDto.getTitle(),
                resumeDto.getCv(),
                resumeDto.getOpenforheadhunter()));

        return resume;

    }

    // DB 에 저장된 이력서 정보를 수정하는 코드
    public Resume inputData(Long id, ResumeDto resumeDto) {
        Optional<Resume> resumeData = resumeRepository.findById(id);
        Resume resume = resumeData.get();
        resume.setTitle(resumeDto.getTitle());
        resume.setCv(resumeDto.getCv());
        resume.setOpenforheadhunter(resumeDto.getOpenforheadhunter());
        resumeRepository.save(resume);
        return resume;
    }

    // DB에 저당된 이력서를 삭제하는 코드
    public void deleteData(Long id) {
        resumeRepository.deleteById(id);
    }

}
