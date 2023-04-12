package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.EducationDto;
import com.example.demo.recruit.entity.Education;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.EducationRepository;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationService {

    @Autowired
    private final EducationRepository educationRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 해당 이력서 조회 시 교육내용을 함께 조회하기 위한 코드
    public List<Education> geteducation(Resume resume) {
        List<Education> education = new ArrayList<Education>();
        educationRepository.findByResume(resume).forEach(education::add);
        return education;
    }

    // 해당 교육내용만 조회하는 코드
    public Education geteducation(Long id) {
        Optional<Education> educationData = educationRepository.findById(id);
        Education education = educationData.get();
        return education;
    }

    // 교육내용을 입력받아 DB 에 저장하는 코드
    public List<Education> inputData(List<EducationDto> educationDtoList, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Education> educationList = new ArrayList<>();
        for (int i = 0; i < educationDtoList.size(); i++) {
            EducationDto educationDto = educationDtoList.get(i);
            Education education = this.educationRepository.save(new Education(
                    resume,
                    educationDto.getStart(),
                    educationDto.getEnd(),
                    educationDto.getTitle(),
                    educationDto.getHoldby(),
                    educationDto.getDetail()));
            educationList.add(education);
        }
        return educationList;
    }

    // DB 에 저장된 교육내용을 수정하는 코드
    public List<Education> inputData(Resume resume, List<EducationDto> educationDtoList) {
        List<Education> educationList = this.educationRepository.findAllByResume(resume);
        List<Education> educationResult = new ArrayList<>();

        if (educationDtoList.size() == educationList.size()) {
            for (int i = 0; i < educationDtoList.size(); i++) {
                educationList.get(i).setStart(educationDtoList.get(i).getStart());
                educationList.get(i).setEnd(educationDtoList.get(i).getEnd());
                educationList.get(i).setTitle(educationDtoList.get(i).getTitle());
                educationList.get(i).setHoldby(educationDtoList.get(i).getHoldby());
                educationList.get(i).setDetail(educationDtoList.get(i).getDetail());
                educationResult.add(educationList.get(i));
                this.educationRepository.save(educationList.get(i));
            }

        } else if (educationDtoList.size() > educationList.size()) {
            for (int i = 0; i < educationList.size(); i++) {
                educationList.get(i).setStart(educationDtoList.get(i).getStart());
                educationList.get(i).setEnd(educationDtoList.get(i).getEnd());
                educationList.get(i).setTitle(educationDtoList.get(i).getTitle());
                educationList.get(i).setHoldby(educationDtoList.get(i).getHoldby());
                educationList.get(i).setDetail(educationDtoList.get(i).getDetail());
                educationResult.add(educationList.get(i));
                this.educationRepository.save(educationList.get(i));
            }

            for (int i = educationList.size(); i < educationDtoList.size(); i++) {
                Education education = this.educationRepository.save(new Education(
                        resume,
                        educationDtoList.get(i).getStart(),
                        educationDtoList.get(i).getEnd(),
                        educationDtoList.get(i).getTitle(),
                        educationDtoList.get(i).getHoldby(),
                        educationDtoList.get(i).getDetail()));
                educationResult.add(education);
            }
        } else if (educationDtoList.size() < educationList.size()) {
            for (int i = 0; i < educationDtoList.size(); i++) {
                educationList.get(i).setStart(educationDtoList.get(i).getStart());
                educationList.get(i).setEnd(educationDtoList.get(i).getEnd());
                educationList.get(i).setTitle(educationDtoList.get(i).getTitle());
                educationList.get(i).setHoldby(educationDtoList.get(i).getHoldby());
                educationList.get(i).setDetail(educationDtoList.get(i).getDetail());
                educationResult.add(educationList.get(i));
                this.educationRepository.save(educationList.get(i));
            }

            for (int i = educationDtoList.size(); i < educationList.size(); i++) {
                this.educationRepository.deleteById(educationList.get(i).getId());
            }
        }
        return educationResult;
    }

    // DB 에 저장된 교육내용을 삭제하는 코드
    public void deleteData(Long id) {
        this.educationRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Education> education = new ArrayList<Education>();
        this.educationRepository.findByResume(resume).forEach(education::add);
        this.educationRepository.deleteAll(education);
    }
}
