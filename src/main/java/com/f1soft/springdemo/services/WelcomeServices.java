package com.f1soft.springdemo.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class WelcomeServices {

    private String welcomeMessage;


    @Value("${welcome.message}")
    public  String getWelcomeMessage(){
        return welcomeMessage;
    }



}
