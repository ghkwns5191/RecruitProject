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

    @Column(name = "filename")
    private String filename;

    @Column(name = "oriname")
    private String oriname;

    @Column(name = "fileurl")
    private String fileurl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio")
    private Portfolio portfolio;

    public Portfoliofile() {

    }

    public Portfoliofile(String filename, String oriname, String fileurl, Portfolio portfolio) {
        super();
        this.filename = filename;
        this.oriname = oriname;
        this.fileurl = fileurl;
        this.portfolio = portfolio;
    }
    
    public void updatefile(String oriname, String filename, String fileurl) {
        this.filename = filename;
        this.oriname = oriname;
        this.fileurl = fileurl;
    }

}
