package com.example.demo.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.recruit.entity.Notice;
import com.example.demo.recruit.repository.NoticeRepository;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping
    public List<Notice> getNotice() {
        List<Notice> notice = new ArrayList<Notice>();
        noticeRepository.findAll().forEach(notice::add);
        return notice;
    }

    @GetMapping
    public Notice getNotice(Long id_notice) {
        Optional<Notice> noticeData = noticeRepository.findById(id_notice);
        Notice notice = noticeData.get();
        return notice;
    }
}
