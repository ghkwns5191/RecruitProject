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

@Setter
@Getter
@Table(name = "portfoliofileapply")
@Entity
public class PortfoliofileApply {

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
    private PortfolioApply portfolioApply;
    
    public PortfoliofileApply() {
        // TODO Auto-generated constructor stub
    }

    public PortfoliofileApply(String filename, String oriname, String fileurl, PortfolioApply portfolioApply) {
        super();
        this.filename = filename;
        this.oriname = oriname;
        this.fileurl = fileurl;
        this.portfolioApply = portfolioApply;
    }
    
    
}
