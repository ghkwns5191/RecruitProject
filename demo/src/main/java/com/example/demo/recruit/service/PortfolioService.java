package com.example.demo.recruit.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.recruit.dto.PortfolioDto;
import com.example.demo.recruit.entity.Member;
import com.example.demo.recruit.entity.Portfolio;
import com.example.demo.recruit.entity.Portfoliofile;
import com.example.demo.recruit.entity.Resume;
import com.example.demo.recruit.repository.MemberRepository;
import com.example.demo.recruit.repository.PortfolioRepository;
import com.example.demo.recruit.repository.ResumeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    @Autowired
    private final PortfolioRepository portfolioRepository;

    @Autowired
    private final ResumeRepository resumeRepository;

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final PortfoliofileService portfoliofileService;

    // 해당 이력서의 포트폴리오 정보를 불러오는 코드
    public List<Portfolio> getPortfolio(Resume resume) {
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        portfolioRepository.findByResume(resume).forEach(portfolio::add);
        return portfolio;
    }

    // 해당 포트폴리오 정보만 불러오는 코드
    public Portfolio getPortfolio(Long id) {
        Optional<Portfolio> portfolioData = portfolioRepository.findById(id);
        Portfolio portfolio = portfolioData.get();
        return portfolio;
    }

    // 입력받은 포트폴리오 정보를 DB 에 저장하는 코드
    public List<Portfolio> inputData(List<String> titleList, List<String> url1List, List<String> url2List,
            List<MultipartFile> portfoliofileList,
            Principal principal) throws Exception {
        String username = principal.getName();
        Member member = this.memberRepository.findByUsername(username);
        Resume resume = this.resumeRepository.findByMember(member);
        List<Portfolio> portfolioList = new ArrayList<>();
        for (int i = 0; i < titleList.size(); i++) {
            String title = titleList.get(i);
            String url1 = url1List.get(i);
            String url2 = url2List.get(i);
            Portfolio portfolio = this.portfolioRepository.save(new Portfolio(
                    resume,
                    title,
                    url1,
                    url2));
            portfolioList.add(portfolio);

            Portfoliofile portfoliofile = new Portfoliofile();
            portfoliofile.setPortfolio(portfolio);
            portfoliofileService.savefile(portfoliofile, portfoliofileList.get(i));

        }
        return portfolioList;
    }

    // DB 에 저장된 포트폴리오 내역을 수정하는 코드
    public List<Portfolio> inputData(Resume resume, List<MultipartFile> portfoliofile, List<String> titleList,
            List<String> url1List, List<String> url2List) throws Exception {
        List<Portfolio> portfolioList = this.portfolioRepository.findAllByResume(resume);
        List<Portfolio> portfolioResult = new ArrayList<>();
        System.out.println(titleList.size());
        System.out.println(portfoliofile.size());
        if (titleList.size() == portfoliofile.size()) {
            if (titleList.size() == portfolioList.size()) {
                for (int i = 0; i < titleList.size(); i++) {
                    portfolioList.get(i).setTitle(titleList.get(i));
                    portfolioList.get(i).setUrl1(url1List.get(i));
                    portfolioList.get(i).setUrl2(url2List.get(i));
                    this.portfolioRepository.save(portfolioList.get(i));
                    portfolioResult.add(portfolioList.get(i));

                    Portfoliofile portfoliofiledata = this.portfoliofileService.getfile(portfolioList.get(i));
                    if (!portfoliofile.get(i).getOriginalFilename().equals(portfoliofiledata.getOriname())) {
                        this.portfoliofileService.deleteFile(portfoliofiledata);
                        Portfoliofile newfile = new Portfoliofile();
                        newfile.setPortfolio(portfolioList.get(i));
                        this.portfoliofileService.savefile(newfile, portfoliofile.get(i));
                    }
                }
            } else if (titleList.size() > portfolioList.size()) {
                for (int i = 0; i < portfolioList.size(); i++) {
                    portfolioList.get(i).setTitle(titleList.get(i));
                    portfolioList.get(i).setUrl1(url1List.get(i));
                    portfolioList.get(i).setUrl2(url2List.get(i));
                    this.portfolioRepository.save(portfolioList.get(i));
                    portfolioResult.add(portfolioList.get(i));

                    Portfoliofile portfoliofiledata = this.portfoliofileService.getfile(portfolioList.get(i));
                    if (!portfoliofile.get(i).getOriginalFilename().equals(portfoliofiledata.getOriname())) {
                        this.portfoliofileService.deleteFile(portfoliofiledata);
                        Portfoliofile newfile = new Portfoliofile();
                        newfile.setPortfolio(portfolioList.get(i));
                        this.portfoliofileService.savefile(newfile, portfoliofile.get(i));
                    }
                }

                for (int i = portfolioList.size(); i < titleList.size(); i++) {
                    Portfolio portfolio = this.portfolioRepository.save(new Portfolio(
                            resume,
                            titleList.get(i),
                            url1List.get(i),
                            url2List.get(i)));
                    portfolioResult.add(portfolio);
                    Portfoliofile newfile = new Portfoliofile();
                    newfile.setPortfolio(portfolio);
                    this.portfoliofileService.savefile(newfile, portfoliofile.get(i));
                }
            } else if (titleList.size() < portfolioList.size()) {
                for (int i = 0; i < titleList.size(); i++) {
                    portfolioList.get(i).setTitle(titleList.get(i));
                    portfolioList.get(i).setUrl1(url1List.get(i));
                    portfolioList.get(i).setUrl2(url2List.get(i));
                    this.portfolioRepository.save(portfolioList.get(i));
                    portfolioResult.add(portfolioList.get(i));

                    Portfoliofile portfoliofiledata = this.portfoliofileService.getfile(portfolioList.get(i));
                    if (!portfoliofile.get(i).getOriginalFilename().equals(portfoliofiledata.getOriname())) {
                        this.portfoliofileService.deleteFile(portfoliofiledata);
                        Portfoliofile newfile = new Portfoliofile();
                        newfile.setPortfolio(portfolioList.get(i));
                        this.portfoliofileService.savefile(newfile, portfoliofile.get(i));
                    }
                }

                for (int i = titleList.size(); i < portfolioList.size(); i++) {
                    Portfoliofile portfoliofileData = this.portfoliofileService.getfile(portfolioList.get(i));
                    this.portfoliofileService.deleteFile(portfoliofileData);
                    this.portfolioRepository.deleteById(portfolioList.get(i).getId());
                }
            }
        }
        return portfolioResult;

    }

    // DB 에 저장된 포트폴리오 내역을 삭제하는 코드
    public void deleteData(Long id) {
        this.portfolioRepository.deleteById(id);
    }

    // 이력서 삭제 시 사용할 코드
    public void deleteResume(Long id) {
        Optional<Resume> resumeData = this.resumeRepository.findById(id);
        Resume resume = resumeData.get();
        List<Portfolio> portfolio = new ArrayList<Portfolio>();
        this.portfolioRepository.findByResume(resume).forEach(portfolio::add);
        this.portfolioRepository.deleteAll(portfolio);
    }
}
