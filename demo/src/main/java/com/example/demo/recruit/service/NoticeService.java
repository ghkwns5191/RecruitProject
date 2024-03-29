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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {

    @Autowired
    private final NoticeRepository noticeRepository;

    // 공지사항의 모든 리스트를 불러오는 코드
    
    public List<Notice> getNotice() {
        List<Notice> notice = new ArrayList<Notice>();
        noticeRepository.findAll().forEach(notice::add);
        return notice;
    }
    
    public List<Notice> getNotice5() {
        List<Notice> noticeList = this.noticeRepository.findTop5ByOrderByRegisterdateDesc();
        return noticeList;
    }

    // 해당 공지사항의 상세 내용을 불러오는 코드
   
    public Notice getNotice(Long id) {
        Optional<Notice> noticeData = noticeRepository.findById(id);
        Notice notice = noticeData.get();
        return notice;
    }

    // 공지사항 작성 내용을 입력받아 DB 에 저장하는 코드
    public Notice inputData(NoticeDto noticeDto) {
        Notice notice = this.noticeRepository.save(new Notice(
                noticeDto.getMember(),
                noticeDto.getTitle(),
                noticeDto.getDetail(),
                LocalDate.now(),
                null));
        return notice;
    }
    
    // DB 에 저장된 공지사항을 수정하는 코드
    public Notice inputData(Long id, NoticeDto noticeDto) {
        Optional<Notice> noticeData = this.noticeRepository.findById(id);
        Notice notice = noticeData.get();
        notice.setTitle(noticeDto.getTitle());
        notice.setDetail(noticeDto.getDetail());
        notice.setRegisterdate(noticeDto.getRegisterdate());
        notice.setModifydate(LocalDate.now());
        this.noticeRepository.save(notice);
        return notice;
    }
    
    // DB 에 저장된 공지사항을 삭제하는 코드
    public void deleteData(Long id) {
        this.noticeRepository.deleteById(id);
    }

}
