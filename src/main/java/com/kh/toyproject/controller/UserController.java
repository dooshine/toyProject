package com.kh.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    
//    로그인 화면
    @GetMapping("/login")
    public String login(){
        return "user/userlogin";
    }
//    회원가입 화면
//    회원정보 수정 화면
//    회원정보 수정 처리
//    회원탈퇴 화면
//    회원탈퇴 처리
//    회원정보 상세 조회 화면
//    회원정보 목록 조회 화면
//    회원정보 목록 조회 처리
//    회원정보 목록 엑셀 다운로드
//    회원정보 목록 엑셀 업로드
//    회원정보 목록 엑셀 업로드 처리
//    회원정보 목록 엑셀 업로드 결과 조회
}
