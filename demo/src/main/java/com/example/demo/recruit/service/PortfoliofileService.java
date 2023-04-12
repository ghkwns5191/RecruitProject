package com.example.demo.recruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Portfoliofile;
import com.example.demo.recruit.repository.PortfoliofileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfoliofileService {

    @Value("${PortfoliofileLocation1}")
    private String PortfoliofileLocation1;

    @Value("${PortfoliofileLocation2}")
    private String PortfoliofileLocation2;

    @Autowired
    private final PortfoliofileRepository portfoliofileRepository;

    @Autowired
    private final FileService fileService;

    public Portfoliofile savefile(Portfoliofile portfoliofile, MultipartFile multipartfile) throws Exception {
        String originalname = multipartfile.getOriginalFilename();
        String filename = "";
        String fileurl = "";

        // 파일 업로드
        if (!StringUtils.isEmpty(originalname)) {
            filename = fileService.uploadFile(PortfoliofileLocation1, PortfoliofileLocation2, originalname,
                    multipartfile.getBytes());
            fileurl = "/portfoliofile/" + filename;
        }

        // 이미지 정보 DB에 저장
        portfoliofile.updatefile(originalname, filename, fileurl);
        Portfoliofile result = portfoliofileRepository.save(portfoliofile);

        return result;

    }

    public Portfoliofile getfile(Portfolio portfolio) {
        Portfoliofile portfoliofile = this.portfoliofileRepository.findByPortfolio(portfolio);

        return portfoliofile;
    }
}
