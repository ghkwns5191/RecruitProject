package com.example.demo.recruit.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.demo.recruit.entity.Apply;
import com.example.demo.recruit.entity.Imgfile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImgfileApplyDto {

    private Long id;

    private String imgname;

    private String oriname;

    private String imgurl;
    
    private Apply apply;
    
    // 이미지 저장 후 수정할 때 이미지 정보를 저장하는 리스트
    private List<ImgfileDto> imgfileDtoList = new ArrayList<>();
    
    // 이미지 파일 아이디를 저장하는 리스트, 최초 등록 시에는 아무겂도 없음. 수정 시에 이미지 아이디를 담아두는 용도
    private List<Long> imgfileIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public static ImgfileDto of(Imgfile imgfile) {
        return modelMapper.map(imgfile, ImgfileDto.class);
    }

    public ImgfileApplyDto(String imgname, String oriname, String imgurl, Apply apply) {
        super();
        this.imgname = imgname;
        this.oriname = oriname;
        this.imgurl = imgurl;
        this.apply = apply;
    }

    public ImgfileApplyDto() {
        // TODO Auto-generated constructor stub
    }
    
}
