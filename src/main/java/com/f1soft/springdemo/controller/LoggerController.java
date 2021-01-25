package com.f1soft.springdemo.controller;

import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//
@Component
@RestController

public class LoggerController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/logger")
    public String executeLogger() {
        log.info("inside the executeLogger method");
        return "Hello World Logger Interceptor";
    }





//
}
