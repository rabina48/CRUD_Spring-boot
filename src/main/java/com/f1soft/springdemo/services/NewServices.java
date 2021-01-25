package com.f1soft.springdemo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component

@Profile({"dev","prod"}) //requirement of object enable
public class NewServices {

    private final WelcomeServices services;

    public NewServices(WelcomeServices services) {
        this.services = services;
    }


//    public NewServices(WelcomeServices services)
//    {
//        this.services =services;
//    }

    @PostConstruct
    public void init(){
        System.out.println("This instance is only created in dev environment!");
    }



}
