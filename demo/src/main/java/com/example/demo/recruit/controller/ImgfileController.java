package com.example.demo.recruit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.ResumeRepository;
import com.example.demo.recruit.service.ImgfileService;
import com.example.demo.recruit.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/imgfile")
public class ImgfileController {

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final ImgfileService imgfileService;

    @Autowired
    private final ResumeService resumeService;

    @PostMapping("/new")
    public ResponseEntity<Imgfile> inputImg(@RequestParam("imgfile") MultipartFile imgfile, Principal principal) {

        try {
            String username = principal.getName();
            Member member = this.memberRepository.findByUsername(username);
            Resume resume = this.resumeRepository.findByMember(member);

            Imgfile imgfiles = new Imgfile();
            imgfiles.setResume(resume);
            Imgfile result = imgfileService.saveImgfile(imgfiles, imgfile);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{id}")
    public void deleteImg(@PathVariable("id") Long id) {
        Resume resume = this.resumeService.getResume(id);
        Imgfile imgfile = this.imgfileService.getimgfile(resume);
        try {
            this.imgfileService.deleteImg(imgfile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @PutMapping("/revise/{id}")
    public ResponseEntity<Imgfile> reviseImg(@PathVariable("id") Long id,
            @RequestParam("imgfileNew") MultipartFile multipartfile) {
        try {
            Resume resume = this.resumeService.getResume(id);
            Imgfile imgfile = this.imgfileService.getimgfile(resume);
            this.imgfileService.deleteImg(imgfile);

            Imgfile imgfileNew = new Imgfile();
            imgfileNew.setResume(resume);
            Imgfile result = this.imgfileService.saveImgfile(imgfileNew, multipartfile);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
