package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.CareerDto;
import com.example.demo.recruit.entity.Career;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.CareerRepository;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CareerService {

    @Autowired
    private final CareerRepository careerRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 해당 이력서의 경력사항을 불러오는 코드
    public List<Career> getcareer(Resume resume) {
        List<Career> career = new ArrayList<Career>();
        this.careerRepository.findByResume(resume).forEach(career::add);
        return career;
    }

    // 해당 경력사항만 불러오는 코드
    public Career getcareer(Long id) {
        Optional<Career> careerData = this.careerRepository.findById(id);
        Career career = careerData.get();
        return career;
    }

    // 경력사항을 입력받아 DB 에 저장하는 코드
    public List<Career> inputData(List<CareerDto> careerDtoList, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Career> careerList = new ArrayList<>();
        for (int i = 0; i < careerDtoList.size(); i++) {
            CareerDto careerDto = careerDtoList.get(i);
            Career career = this.careerRepository.save(new Career(
                    resume,
                    careerDto.getStart(),
                    careerDto.getEnd(),
                    careerDto.getWorking(),
                    careerDto.getCompanyname(),
                    careerDto.getRanks(),
                    careerDto.getSalary(),
                    careerDto.getJobduty(),
                    careerDto.getDetail()));
            careerList.add(career);
        }
        return careerList;
    }

    // 경력사항을 수정하여 DB 에 저장하는 코드
    public List<Career> inputData(Resume resume, List<CareerDto> careerDtoList) {
        List<Career> careerList = this.careerRepository.findAllByResume(resume);
        List<Career> careerResult = new ArrayList<>();
        
        if (careerDtoList.size() == careerList.size()) {
            for (int i = 0; i < careerDtoList.size(); i++) {
                careerList.get(i).setStart(careerDtoList.get(i).getStart());
                careerList.get(i).setEnd(careerDtoList.get(i).getEnd());
                careerList.get(i).setWorking(careerDtoList.get(i).getWorking());
                careerList.get(i).setCompanyname(careerDtoList.get(i).getCompanyname());
                careerList.get(i).setRanks(careerDtoList.get(i).getRanks());
                careerList.get(i).setSalary(careerDtoList.get(i).getSalary());
                careerList.get(i).setJobduty(careerDtoList.get(i).getJobduty());
                careerList.get(i).setDetail(careerDtoList.get(i).getDetail());
                careerResult.add(careerList.get(i));
                this.careerRepository.save(careerList.get(i));
            }
            
        } else if (careerDtoList.size() > careerList.size()) {
            for (int i = 0; i < careerList.size(); i++) {
                careerList.get(i).setStart(careerDtoList.get(i).getStart());
                careerList.get(i).setEnd(careerDtoList.get(i).getEnd());
                careerList.get(i).setWorking(careerDtoList.get(i).getWorking());
                careerList.get(i).setCompanyname(careerDtoList.get(i).getCompanyname());
                careerList.get(i).setRanks(careerDtoList.get(i).getRanks());
                careerList.get(i).setSalary(careerDtoList.get(i).getSalary());
                careerList.get(i).setJobduty(careerDtoList.get(i).getJobduty());
                careerList.get(i).setDetail(careerDtoList.get(i).getDetail());
                careerResult.add(careerList.get(i));
                this.careerRepository.save(careerList.get(i));
            }
            
            for (int i = careerList.size(); i < careerDtoList.size(); i++) {
                Career career = this.careerRepository.save(new Career(
                        resume,
                        careerDtoList.get(i).getStart(),
                        careerDtoList.get(i).getEnd(),
                        careerDtoList.get(i).getWorking(),
                        careerDtoList.get(i).getCompanyname(),
                        careerDtoList.get(i).getRanks(),
                        careerDtoList.get(i).getSalary(),
                        careerDtoList.get(i).getJobduty(),
                        careerDtoList.get(i).getDetail()
                        ));
                careerResult.add(career);
            }
        } else if (careerDtoList.size() < careerList.size()) {
            for (int i = 0; i < careerDtoList.size(); i++) {
                careerList.get(i).setStart(careerDtoList.get(i).getStart());
                careerList.get(i).setEnd(careerDtoList.get(i).getEnd());
                careerList.get(i).setWorking(careerDtoList.get(i).getWorking());
                careerList.get(i).setCompanyname(careerDtoList.get(i).getCompanyname());
                careerList.get(i).setRanks(careerDtoList.get(i).getRanks());
                careerList.get(i).setSalary(careerDtoList.get(i).getSalary());
                careerList.get(i).setJobduty(careerDtoList.get(i).getJobduty());
                careerList.get(i).setDetail(careerDtoList.get(i).getDetail());
                careerResult.add(careerList.get(i));
                this.careerRepository.save(careerList.get(i));
            }
            
            for (int i = careerDtoList.size(); i < careerList.size(); i++) {
                this.careerRepository.deleteById(careerList.get(i).getId());
            }
        }
        
        return careerResult;
    }

    // 경력사항 삭제하는 코드
    public void deleteData(Long id) {
        this.careerRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Career> career = new ArrayList<Career>();
        this.careerRepository.findByResume(resume).forEach(career::add);
        this.careerRepository.deleteAll(career);
    }
}
