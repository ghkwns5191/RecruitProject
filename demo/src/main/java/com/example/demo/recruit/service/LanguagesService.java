package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.recruit.dto.LanguagesDto;
import com.example.demo.recruit.entity.Languages;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.LanguagesRepository;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguagesService {

    @Autowired
    private final LanguagesRepository languagesRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    // 이력서 조회 시 어학사항 함께 조회하는 코드
    public List<Languages> getlanguages(Resume resume) {
        List<Languages> languages = new ArrayList<Languages>();
        languagesRepository.findByResume(resume).forEach(languages::add);
        return languages;
    }

    // 해당 어학사항만 조회하는 코드
    public Languages getlanguages(Long id) {
        Optional<Languages> languagesData = languagesRepository.findById(id);
        Languages languages = languagesData.get();
        return languages;
    }

    // 어학사항을 입력받아 DB 에 저장하는 코드
    public List<Languages> inputData(List<LanguagesDto> languagesDtoList, Principal principal) {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Languages> languagesList = new ArrayList<>();
        for (int i = 0; i < languagesDtoList.size(); i++) {
            LanguagesDto languagesDto = languagesDtoList.get(i);
            Languages languages = this.languagesRepository.save(new Languages(
                    resume,
                    languagesDto.getLanguages(),
                    languagesDto.getLeveltalking(),
                    languagesDto.getLevelwriting(),
                    languagesDto.getTest(),
                    languagesDto.getScore(),
                    languagesDto.getAchievedate(),
                    languagesDto.getCertificatenumber()));
            languagesList.add(languages);
        }
        return languagesList;
    }

    // DB 에 저장된 어학사항을 수정하는 코드
    public List<Languages> inputData(Resume resume, List<LanguagesDto> languagesDtoList) {
        List<Languages> languagesList = this.languagesRepository.findAllByResume(resume);
        List<Languages> languagesResult = new ArrayList<>();
        
        if (languagesDtoList.size() == languagesList.size()) {
            for (int i = 0; i < languagesDtoList.size(); i++) {
                languagesList.get(i).setLanguages(languagesDtoList.get(i).getLanguages());
                languagesList.get(i).setLeveltalking(languagesDtoList.get(i).getLeveltalking());
                languagesList.get(i).setLevelwriting(languagesDtoList.get(i).getLevelwriting());
                languagesList.get(i).setTest(languagesDtoList.get(i).getTest());
                languagesList.get(i).setScore(languagesDtoList.get(i).getScore());
                languagesList.get(i).setAchievedate(languagesDtoList.get(i).getAchievedate());
                languagesList.get(i).setCertificatenumber(languagesDtoList.get(i).getCertificatenumber());
                languagesResult.add(languagesList.get(i));
                this.languagesRepository.save(languagesList.get(i));
            }
        } else if (languagesDtoList.size() > languagesList.size()) {
            for (int i = 0; i < languagesList.size(); i++) {
                languagesList.get(i).setLanguages(languagesDtoList.get(i).getLanguages());
                languagesList.get(i).setLeveltalking(languagesDtoList.get(i).getLeveltalking());
                languagesList.get(i).setLevelwriting(languagesDtoList.get(i).getLevelwriting());
                languagesList.get(i).setTest(languagesDtoList.get(i).getTest());
                languagesList.get(i).setScore(languagesDtoList.get(i).getScore());
                languagesList.get(i).setAchievedate(languagesDtoList.get(i).getAchievedate());
                languagesList.get(i).setCertificatenumber(languagesDtoList.get(i).getCertificatenumber());
                languagesResult.add(languagesList.get(i));
                this.languagesRepository.save(languagesList.get(i));
            }
            
            for (int i = languagesList.size(); i < languagesDtoList.size(); i++) {
                Languages languages = this.languagesRepository.save(new Languages(
                        resume,
                        languagesDtoList.get(i).getLanguages(),
                        languagesDtoList.get(i).getLeveltalking(),
                        languagesDtoList.get(i).getLevelwriting(),
                        languagesDtoList.get(i).getTest(),
                        languagesDtoList.get(i).getScore(),
                        languagesDtoList.get(i).getAchievedate(),
                        languagesDtoList.get(i).getCertificatenumber()
                        ));
                languagesResult.add(languages);
            }
        } else if (languagesDtoList.size() < languagesList.size()) {
            for (int i = 0; i < languagesDtoList.size(); i++) {
                languagesList.get(i).setLanguages(languagesDtoList.get(i).getLanguages());
                languagesList.get(i).setLeveltalking(languagesDtoList.get(i).getLeveltalking());
                languagesList.get(i).setLevelwriting(languagesDtoList.get(i).getLevelwriting());
                languagesList.get(i).setTest(languagesDtoList.get(i).getTest());
                languagesList.get(i).setScore(languagesDtoList.get(i).getScore());
                languagesList.get(i).setAchievedate(languagesDtoList.get(i).getAchievedate());
                languagesList.get(i).setCertificatenumber(languagesDtoList.get(i).getCertificatenumber());
                languagesResult.add(languagesList.get(i));
                this.languagesRepository.save(languagesList.get(i));
            }
            
            for (int i = languagesDtoList.size(); i < languagesList.size(); i++) {
                this.languagesRepository.deleteById(languagesList.get(i).getId());
            }
        }
        
        return languagesResult;
    }

    // DB 에 저장된 어학사항을 삭제하는 코드
    public void deleteData(Long id) {
        this.languagesRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Languages> languages = new ArrayList<Languages>();
        this.languagesRepository.findByResume(resume).forEach(languages::add);
        this.languagesRepository.deleteAll(languages);
    }
}
