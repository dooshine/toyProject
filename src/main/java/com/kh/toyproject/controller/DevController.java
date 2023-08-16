package com.kh.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class DevController {

    @GetMapping("/")
    public String home(){
        return "dev/devHome";
    }

    @GetMapping("/db")
    public String db(){
        return "dev/devDb";
    }

    @GetMapping("/imp")
    public String imp(){
        return "dev/devImp";
    }
}
