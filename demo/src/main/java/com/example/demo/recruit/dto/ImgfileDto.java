package com.example.demo.recruit.dto;

import org.modelmapper.ModelMapper;

import com.example.demo.recruit.entity.Imgfile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImgfileDto {

    private Long id;
    
    private String imgname;
    
    private String oriname;
    
    private String imgurl;
                                                                                                                                                                                                                                                                                                                                
    private static ModelMapper modelMapper = new ModelMapper();
    
    public static ImgfileDto of(Imgfile imgfile) {
        return modelMapper.map(imgfile, ImgfileDto.class);
    }

    public ImgfileDto(String imgname, String oriname, String imgurl) {
        super();
        this.imgname = imgname;
        this.oriname = oriname;
        this.imgurl = imgurl;
    }
    
    
}
