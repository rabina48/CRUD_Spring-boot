package com.f1soft.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//
@Component
@RestController

public class LoggerController {

    @Value("${welcome.message}")
    public String welcomeMessage;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/logger")
    public String executeLogger() {
        log.info("inside the executeLogger method");
        return "Hello World Logger Interceptor";
    }


    @RequestMapping("/welcome")
    public String getWelcomeMessage() {
        return "Hello :  " +welcomeMessage;
    }


//
}
