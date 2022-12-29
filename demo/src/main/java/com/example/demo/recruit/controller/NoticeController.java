package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.dto.NoticeDto;
import com.example.demo.recruit.entity.Notice;
import com.example.demo.recruit.service.NoticeService;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 모든 공지사항 리스트를 확인하기 위해 사용
    @GetMapping
    public ResponseEntity<List<Notice>> getList() {
        try {
            List<Notice> notice = new ArrayList<Notice>();
            notice = noticeService.getNotice();
            return new ResponseEntity<>(notice, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 해당 공지사항의 상세내용을 확인하기 위해 사용
    @GetMapping
    public ResponseEntity<Notice> getNotice(@RequestParam(required = false) Long id_notice) {
        try {
            Notice notice = new Notice();
            notice = noticeService.getNotice(id_notice);
            return new ResponseEntity<>(notice, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 공지사항 작성내용을 입력받아 DB 에 저장하기 위해 사용
    @PostMapping
    public ResponseEntity<Notice> inputData(@RequestBody NoticeDto noticeDto) {
        try {
            Notice notice = noticeService.inputData(noticeDto);
            return new ResponseEntity<>(notice, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 공지사항을 수정하기 위해 사용
    @PutMapping
    public ResponseEntity<Notice> reviseData(@PathVariable("id_notice") Long id_notice, @RequestBody NoticeDto noticeDto) {
        try {
            Notice notice = noticeService.inputData(id_notice, noticeDto);
            return new ResponseEntity<>(notice, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 공지사항을 삭제하기 위해 사용
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteData(@PathVariable("id_notice") Long id_notice) {
        try {
            noticeService.deleteData(id_notice);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
