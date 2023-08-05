package com.kh.toyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class DevController {

    @GetMapping("/home")
    public String home(){
        return "dev/devHome";
    }
}
