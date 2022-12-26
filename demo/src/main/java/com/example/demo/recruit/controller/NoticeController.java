package com.example.demo.recruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.recruit.entity.Notice;
import com.example.demo.recruit.service.NoticeService;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

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
}
