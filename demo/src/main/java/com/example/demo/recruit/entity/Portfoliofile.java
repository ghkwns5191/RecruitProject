package com.example.demo.recruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "porfoliofile")
public class Portfoliofile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "imgname")
    private String imgname;

    @Column(name = "oriname")
    private String oriname;

    @Column(name = "imgurl")
    private String imgurl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio")
    private Portfolio portfolio;

    public Portfoliofile() {

    }

    public Portfoliofile(String imgname, String oriname, String imgurl, Portfolio portfolio) {
        super();
        this.imgname = imgname;
        this.oriname = oriname;
        this.imgurl = imgurl;
        this.portfolio = portfolio;
    }

}
