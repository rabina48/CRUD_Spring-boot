package com.f1soft.springdemo.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component

@Profile({"prod"}) //requirement of object enable
public class NewServices {

    private final WelcomeServices services;

    private Logger logger = LoggerFactory.getLogger(NewServices.class);


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




    @PreDestroy
    public void initDestory(){
        System.out.println("This instance is Destory after removed out of context!");
    }

}
