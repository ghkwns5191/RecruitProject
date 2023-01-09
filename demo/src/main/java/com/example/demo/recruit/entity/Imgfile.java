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
@Table(name = "imgfile")
@Setter
@Getter
public class Imgfile {

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
    @JoinColumn(name = "resume")
    private Resume resume;

    public Imgfile() {
        // TODO Auto-generated constructor stub
    }

    public Imgfile(String imgname, String oriname, String imgurl, Resume resume) {
        super();
        this.imgname = imgname;
        this.oriname = oriname;
        this.imgurl = imgurl;
        this.resume = resume;
    }

    public Imgfile(String imgname, String oriname, String imgurl) {
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
