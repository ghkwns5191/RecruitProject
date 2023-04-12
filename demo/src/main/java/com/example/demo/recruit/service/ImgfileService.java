package com.example.demo.recruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.example.demo.recruit.entity.Imgfile;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.ImgfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImgfileService {

    @Value("${ImgfileLocation1}")
    private String ImgfileLocation1;
    
    @Value("${ImgfileLocation2}")
    private String ImgfileLocation2;

    @Autowired
    private final ImgfileRepository imgfileRepository;

    @Autowired
    private final FileService fileService;

    public Imgfile saveImgfile(Imgfile imgfile, MultipartFile imgfileFile) throws Exception {
        String orifilename = imgfileFile.getOriginalFilename();
        String imgname = "";
        String imgurl = "";

        // 파일 업로드 파트
        if (!StringUtils.isEmpty(orifilename)) {
            imgname = fileService.uploadFile(ImgfileLocation1, ImgfileLocation2, orifilename, imgfileFile.getBytes());
            imgurl = "/imageuploaded/" + imgname;
        }

        // 이미지 정보 저장
        imgfile.updateimg(orifilename, imgname, imgurl);
        Imgfile result = imgfileRepository.save(imgfile);
        
        return result;
    }
    
    public Imgfile getimgfile(Resume resume) {
        Imgfile imgfile = imgfileRepository.findByResume(resume);
        return imgfile;
    }
    
    public void deleteImg(Imgfile imgfile) throws Exception {
        String filePath1 = ImgfileLocation1.concat(imgfile.getImgurl());
        String filePath2 = ImgfileLocation2.concat(imgfile.getImgurl());
        this.fileService.deleteFile(filePath1, filePath2);
        this.imgfileRepository.deleteById(imgfile.getId());
       
    }

}
