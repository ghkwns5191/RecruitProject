package com.example.demo.recruit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class FileService {

    public String uploadFile(String uploadPath1, String uploadPath2, String oriname, byte[] fileData) throws Exception {
        UUID uuid = UUID.randomUUID();
        String extention = oriname.substring(oriname.lastIndexOf("."));
        String savedfileName = uuid.toString() + extention;
        String filefullUrl1 = uploadPath1 + "/" + savedfileName;
        String filefullUrl2 = uploadPath2 + "/" + savedfileName;
        FileOutputStream fos1 = new FileOutputStream(filefullUrl1);
        FileOutputStream fos2 = new FileOutputStream(filefullUrl2);
        fos1.write(fileData);
        fos2.write(fileData);
        fos1.close();
        fos2.close();
        return savedfileName;
    }

    public void deleteFile(String filePath1, String filePath2) throws Exception {
        File deleteFile1 = new File(filePath1);
        File deleteFile2 = new File(filePath2);
        if (deleteFile1.exists() && deleteFile2.exists()) {
            deleteFile1.delete();
            deleteFile2.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }
}
