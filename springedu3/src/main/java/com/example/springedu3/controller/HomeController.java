package com.example.springedu3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/hello")
    public String hello() {
        return "성공적으로 로그인 했군요!! 환영합니다~~~ HomeController 의 처리 결과입니다.";
    }
    @GetMapping("/user")
    public String user() {
        return "로그인을 하면 누구든 볼 수 있는 페이지 입니다.";
    }
}
