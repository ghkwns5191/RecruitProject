package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.OverseasexperienceDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Overseasexperience;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.OverseasexperienceRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OverseasexperienceService {

    @Autowired
    private final OverseasexperienceRepository overseasexperienceRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 해당 이력서의 해외경험 리스트를 조회하는 코드
    public List<Overseasexperience> getoverseasexperience(Resume resume) {
        List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
        overseasexperienceRepository.findByResume(resume).forEach(overseasexperience::add);
        return overseasexperience;
    }

    // 해당 해외경험만 조회하는 코드
    public Overseasexperience getoverseasexperience(Long id) {
        Optional<Overseasexperience> overseasexperienceData = overseasexperienceRepository.findById(id);
        Overseasexperience overseasexperience = overseasexperienceData.get();
        return overseasexperience;
    }

    // 이력서 작성 시 해외경험을 입력받아 DB 에 저장하는 코드
    public List<Overseasexperience> inputData(List<OverseasexperienceDto> overseasexperienceDtoList,
            Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Overseasexperience> oeList = new ArrayList<>();
        for (int i = 0; i < overseasexperienceDtoList.size(); i++) {
            OverseasexperienceDto overseasexperienceDto = overseasexperienceDtoList.get(i);
            Overseasexperience overseasexperience = this.overseasexperienceRepository.save(new Overseasexperience(
                    resume,
                    overseasexperienceDto.getStart(),
                    overseasexperienceDto.getEnd(),
                    overseasexperienceDto.getStaying(),
                    overseasexperienceDto.getCountry(),
                    overseasexperienceDto.getDetail()));
            oeList.add(overseasexperience);
        }
        return oeList;
    }

    // DB 에 저장된 해외경험을 수정하는 코드
    public List<Overseasexperience> inputData(Resume resume, List<OverseasexperienceDto> oeDtoList) {
        List<Overseasexperience> oeList = this.overseasexperienceRepository.findAllByResume(resume);
        List<Overseasexperience> oeResult = new ArrayList<>();
        if (oeDtoList.size() == oeList.size()) {
            for (int i = 0; i < oeDtoList.size(); i++) {
                oeList.get(i).setStart(oeDtoList.get(i).getStart());
                oeList.get(i).setEnd(oeDtoList.get(i).getEnd());
                oeList.get(i).setStaying(oeDtoList.get(i).getStaying());
                oeList.get(i).setCountry(oeDtoList.get(i).getCountry());
                oeList.get(i).setDetail(oeDtoList.get(i).getDetail());
                oeResult.add(oeList.get(i));
                this.overseasexperienceRepository.save(oeList.get(i));
            }
        } else if (oeDtoList.size() > oeList.size()) {
            for (int i = 0; i < oeList.size(); i++) {
                oeList.get(i).setStart(oeDtoList.get(i).getStart());
                oeList.get(i).setEnd(oeDtoList.get(i).getEnd());
                oeList.get(i).setStaying(oeDtoList.get(i).getStaying());
                oeList.get(i).setCountry(oeDtoList.get(i).getCountry());
                oeList.get(i).setDetail(oeDtoList.get(i).getDetail());
                oeResult.add(oeList.get(i));
                this.overseasexperienceRepository.save(oeList.get(i));
            }
            
            for (int i = oeList.size(); i < oeDtoList.size(); i++) {
                Overseasexperience oe = this.overseasexperienceRepository.save(new Overseasexperience(
                        resume,
                        oeDtoList.get(i).getStart(),
                        oeDtoList.get(i).getEnd(),
                        oeDtoList.get(i).getStaying(),
                        oeDtoList.get(i).getCountry(),
                        oeDtoList.get(i).getDetail()
                        ));
                oeResult.add(oe);
            }
        } else if (oeDtoList.size() < oeList.size()) {
            for (int i = 0; i < oeDtoList.size(); i++) {
                oeList.get(i).setStart(oeDtoList.get(i).getStart());
                oeList.get(i).setEnd(oeDtoList.get(i).getEnd());
                oeList.get(i).setStaying(oeDtoList.get(i).getStaying());
                oeList.get(i).setCountry(oeDtoList.get(i).getCountry());
                oeList.get(i).setDetail(oeDtoList.get(i).getDetail());
                oeResult.add(oeList.get(i));
                this.overseasexperienceRepository.save(oeList.get(i));
            }
            
            for (int i = oeDtoList.size(); i < oeList.size(); i++) {
                this.overseasexperienceRepository.deleteById(oeList.get(i).getId());
            }
        }
        return oeResult;
    }

    // DB 에 저당된 해외경험을 삭제하는 코드
    public void deleteData(Long id) {
        this.overseasexperienceRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Overseasexperience> overseasexperience = new ArrayList<Overseasexperience>();
        this.overseasexperienceRepository.findByResume(resume).forEach(overseasexperience::add);
        this.overseasexperienceRepository.deleteAll(overseasexperience);
    }
}
