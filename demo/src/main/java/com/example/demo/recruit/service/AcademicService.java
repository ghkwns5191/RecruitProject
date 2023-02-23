package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.AcademicDto;
import com.example.demo.recruit.entity.Academic;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.AcademicRepository;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcademicService {

    @Autowired
    private final AcademicRepository academicRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 이력서에 해당하는 학력정보를 불러내는 코드
    public List<Academic> getacademic(Resume resume) {
        List<Academic> academic = new ArrayList<Academic>();
        this.academicRepository.findByResume(resume).forEach(academic::add);

        return academic;
    }

    // 해당 학력정보만 불러내는 코드
    public Academic getacademic(Long id_academic) {
        Optional<Academic> academicData = this.academicRepository.findById(id_academic);
        Academic academic = academicData.get();
        return academic;
    }

    // 학력정보를 입력받아 DB 에 저장하는 코드
    public List<Academic> inputData(List<AcademicDto> academicDtoList, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Academic> academicList = new ArrayList<>();
        for(int i = 0; i < academicDtoList.size(); i++) {
            AcademicDto academicDto = academicDtoList.get(i);
            Academic academic = 
                    this.academicRepository.save(new Academic(
                    resume,
                    academicDto.getStart(),
                    academicDto.getEnd(),
                    academicDto.getStudying(),
                    academicDto.getType(),
                    academicDto.getName(),
                    academicDto.getMajor(),
                    academicDto.getGrade(),
                    academicDto.getGradefull(),
                    academicDto.getDetail()));
            
            academicList.add(academic);
        }
        return academicList;
    }

    // DB 학력정보를 불러와서 수정 후 DB 에 다시 저장하는 코드
    public Academic inputData(Long id, AcademicDto academicDto) {
        Optional<Academic> academicData = this.academicRepository.findById(id);
        Academic academic = academicData.get();
        academic.setStart(academicDto.getStart());
        academic.setEnd(academicDto.getEnd());
        academic.setStudying(academicDto.getStudying());
        academic.setType(academicDto.getType());
        academic.setName(academicDto.getName());
        academic.setMajor(academicDto.getMajor());
        academic.setGrade(academicDto.getGrade());
        academic.setGradefull(academicDto.getGradefull());
        academic.setDetail(academicDto.getDetail());
        this.academicRepository.save(academic);
        return academic;

    }

    // DB 에 저장된 학력정보를 삭제하는 코드
    public void deleteData(Long id) {
        this.academicRepository.deleteById(id);
    }

    // 이력서 삭제할때 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Academic> academic = new ArrayList<Academic>();
        this.academicRepository.findByResume(resume).forEach(academic::add);
        this.academicRepository.deleteAll(academic);
    }

}
