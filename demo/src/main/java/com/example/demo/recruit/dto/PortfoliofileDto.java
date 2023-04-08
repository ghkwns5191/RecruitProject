package com.example.demo.recruit.dto;

import com.example.demo.recruit.entity.Portfolio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfoliofileDto {

    private String imgname;

    private String oriname;

    private String imgurl;

    private Portfolio portfolio;

    public PortfoliofileDto() {

    }

    public PortfoliofileDto(String imgname, String oriname, String imgurl, Portfolio portfolio) {
        super();
        this.imgname = imgname;
        this.oriname = oriname;
        this.imgurl = imgurl;
        this.portfolio = portfolio;
    }

}
