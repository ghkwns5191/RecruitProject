package com.example.demo.recruit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class FileService {

    public String uploadFile(String uploadPath, String oriname, byte[] fileData) throws Exception {
        UUID uuid = UUID.randomUUID();
        String extention = oriname.substring(oriname.lastIndexOf("."));
        String savedfileName = uuid.toString() + extention;
        String filefullUrl = uploadPath + "/" + savedfileName;
        FileOutputStream fos = new FileOutputStream(filefullUrl);
        fos.write(fileData);
        fos.close();
        return savedfileName;
    }

    public void deleteFile(String filePath) throws Exception {
        File deleteFile = new File(filePath);
        if (deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }
}
