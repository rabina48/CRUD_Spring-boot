package com.f1soft.springdemo.schedular;


import com.f1soft.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSchedular {

    @Autowired
    private  UserRepository userRepository;


    @Scheduled(cron = "5-20 0 15 * * ?")
    public void taskScheduling(){
        System.out.println("Task scheduling"+new java.util.Date());
    }


}
