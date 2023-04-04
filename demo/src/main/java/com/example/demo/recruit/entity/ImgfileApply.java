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
@Table(name = "imgfileapply")
@Setter
@Getter
public class ImgfileApply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "imgname")
    private String imgname;

    @Column(name = "oriname")
    private String oriname;

    @Column(name = "imgurl")
    private String imgurl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apply")
    private Apply apply;

    public ImgfileApply() {
        // TODO Auto-generated constructor stub
    }

    public ImgfileApply(String imgname, String oriname, String imgurl, Apply apply) {
        super();
        this.imgname = imgname;
        this.oriname = oriname;
        this.imgurl = imgurl;
        this.apply = apply;
    }

    public ImgfileApply(String imgname, String oriname, String imgurl) {
        super();
        this.imgname = imgname;
        this.oriname = oriname;
        this.imgurl = imgurl;
    }

    public void updateimg(String oriname, String imgname, String imgurl) {
        this.oriname = oriname;
        this.imgname = imgname;
        this.imgurl = imgurl;
    }
}
