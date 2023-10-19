package com.spring.security.example.SpringSecurityExample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class AppController {
    @RequestMapping("/test")
    public String test(){
        log.info("This is working message");
        return "testing message";
    }

}
