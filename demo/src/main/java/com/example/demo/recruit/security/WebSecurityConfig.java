package com.example.demo.recruit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.recruit.service.MemberService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 로그인 및 로그아웃 관련 설정
        http.formLogin()
                .loginPage("로그인페이지")
                .defaultSuccessUrl("성공하면 로딩될 페이지")
                .usernameParameter("username")
                .failureUrl("실패 시 로딩될 페이지")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("로그아웃 컨트롤러 url"))
                .logoutSuccessUrl("로그아웃 성공시 로딩될 페이지");

        // 페이지 접근 권한
        http.authorizeRequests()
                .mvcMatchers("인증 상관없이 접근 가능한 url").permitAll()
                .mvcMatchers("관리자 권한으로만 접근할 수 있는 url").hasRole("ADMIN")
                .anyRequest().authenticated();

        // 인증되지 않은 사용자가 리소스 요청 시 오류 발생시킴
        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
    }

    // 비밀번호 암호화 코드
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder());
    }

    // 인증 제외할 하위 디렉토리 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("css & js & img 등 디렉터리 인증 제외할 디렉토리");
    }
}
