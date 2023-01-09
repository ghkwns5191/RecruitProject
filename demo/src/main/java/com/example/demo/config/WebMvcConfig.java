package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

    // application.properties 에 등록된 uploadPath 값을 불러오는 코드
    @Value("${uploadPath}")
    public String uploadPath;

    // 웹 브라우저에 입력하는 url 이 /images 로 시작하는 경우 uploadPath 경로를 기준으로 파일을 읽어옴
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath);
    }
}
