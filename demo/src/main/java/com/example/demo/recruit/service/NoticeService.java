package com.example.demo.recruit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.recruit.dto.NoticeDto;
import com.example.demo.recruit.entity.Notice;
import com.example.demo.recruit.repository.NoticeRepository;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    // 공지사항의 모든 리스트를 불러오는 코드
    @GetMapping
    public List<Notice> getNotice() {
        List<Notice> notice = new ArrayList<Notice>();
        noticeRepository.findAll().forEach(notice::add);
        return notice;
    }

    // 해당 공지사항의 상세 내용을 불러오는 코드
    @GetMapping
    public Notice getNotice(Long id_notice) {
        Optional<Notice> noticeData = noticeRepository.findById(id_notice);
        Notice notice = noticeData.get();
        return notice;
    }

    // 공지사항 작성 내용을 입력받아 DB 에 저장하는 코드
    public Notice inputData(NoticeDto noticeDto) {
        Notice notice = this.noticeRepository.save(new Notice(
                noticeDto.getId_member(),
                noticeDto.getNotice_title(),
                noticeDto.getNotice_detail(),
                LocalDate.now(),
                null));
        return notice;
    }

}
