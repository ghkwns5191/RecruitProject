package com.example.demo.recruit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.recruit.dto.ResumeDto;
import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeService {

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final ImgfileService imgfileService;

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
    public Resume inputData(ResumeDto resumeDto, MultipartFile imgfileList) throws Exception {
        Resume resume = resumeRepository.save(new Resume(
                resumeDto.getMember(),
                resumeDto.getTitle(),
                resumeDto.getCv(),
                resumeDto.getOpenforheadhunter()));

        Imgfile imgfile = new Imgfile();
        imgfile.setResume(resume);
        imgfileService.saveImgfile(imgfile, imgfileList);

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
