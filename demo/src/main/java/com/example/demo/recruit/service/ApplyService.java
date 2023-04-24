package com.example.demo.recruit.service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Recruit;
import com.example.demo.recruit.repository.ApplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplyService {

    @Autowired
    private final ApplyRepository applyRepository;

    @Autowired
    private final MemberService memberService;

    @Autowired
    private final ResumeService resumeService;

    @Autowired
    private final AcademicApplyService academicApplyService;

    @Autowired
    private final ActivityApplyService activityApplyService;

    @Autowired
    private final CareerApplyService careerApplyService;

    @Autowired
    private final CertificateApplyService certificateApplyService;

    @Autowired
    private final EducationApplyService educationApplyService;

    @Autowired
    private final ImgfileApplyService imgfileApplyService;

    @Autowired
    private final LanguagesApplyService languagesApplyService;

    @Autowired
    private final OverseasexperienceApplyService overseasexperienceApplyService;

    @Autowired
    private final PortfolioApplyService portfolioApplyService;

    // 해당 회원이 지원한 지원 정보를 불러오는 코드
    public List<Apply> getapply(Member member) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findAllByMember(member).forEach(apply::add);
        return apply;
    }

    // 해당 채용공고에 지원한 지원 정보를 불러오는 코드
    public List<Apply> getapply(Recruit recruit) {
        List<Apply> apply = new ArrayList<Apply>();
        this.applyRepository.findAllByRecruit(recruit).forEach(apply::add);
        return apply;
    }

    public Page<Apply> getapply(Recruit recruit, Pageable pageable) {
        Page<Apply> apply = this.applyRepository.findAllByRecruit(recruit, pageable);
        return apply;
    }

    public List<Apply> getapply5(Member member) {
        List<Apply> applyList = this.applyRepository.findTop5ByMemberByOrderByApplydateDesc(member);
        return applyList;
    }

    // 해당 지원 정보만 불러오는 코드
    public Apply getapply(Long id) {
        Optional<Apply> applyData = this.applyRepository.findById(id);
        Apply apply = applyData.get();
        return apply;
    }

    // 지원 정보를 입력받아 DB 에 저장하는 코드
    public Apply inputData(Principal principal, Recruit recruit) {
        Member member = this.memberService.getMemberinfo(principal.getName());

        Apply apply = this.applyRepository.save(new Apply(
                member,
                recruit,
                member.getName(),
                member.getPhone(),
                member.getEmail(),
                member.getBirthday(),
                member.getAddress(),
                this.resumeService.getResume(member).getTitle(),
                this.resumeService.getResume(member).getCv(),
                LocalDate.now()));
        return apply;
    }

    // 지원 정보를 삭제하는 코드
    public void deleteData(Long id) {
        Optional<Apply> applyData = this.applyRepository.findById(id);
        Apply apply = applyData.get();
        this.academicApplyService.deleteList(apply);
        this.activityApplyService.deleteList(apply);
        this.careerApplyService.deleteList(apply);
        this.certificateApplyService.deleteList(apply);
        this.educationApplyService.deleteList(apply);
        this.languagesApplyService.deleteList(apply);
        this.overseasexperienceApplyService.deleteList(apply);
        this.imgfileApplyService.deleteData(apply);
        this.portfolioApplyService.deleteList(apply);
        this.applyRepository.deleteById(id);
    }

    // 회원정보 및 채용공고 사이트를 이용하여 지원내역을 찾는 코드
    public Apply getapply(Recruit recruit, Member member) {
        Apply apply = this.applyRepository.findByRecruitAndMember(recruit, member);
        return apply;
    }
}
