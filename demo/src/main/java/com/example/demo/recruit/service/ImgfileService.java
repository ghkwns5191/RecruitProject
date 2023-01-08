package com.example.demo.recruit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.repository.ImgfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImgfileService {

    @Value("${ImgfileLocation}")
    private String ImgfileLocation;

    private final ImgfileRepository imgfileRepository;

    private final FileService fileService;

    public String saveImgfile(Imgfile imgfile, MultipartFile imgfileFile) throws Exception {
        String orifilename = imgfileFile.getOriginalFilename();
        String imgname = "";
        String imgurl = "";

        // 파일 업로드 파트
        if (!StringUtils.isEmpty(orifilename)) {
            imgname = fileService.uploadFile(ImgfileLocation, orifilename, imgfileFile.getBytes());
            imgurl = "/이미지 저장위치/" + imgname;
        }

        // 이미지 정보 저장
        imgfile.updateimg(orifilename, imgname, imgurl);
        imgfileRepository.save(imgfile);
        return imgurl;
    }

}
