package com.f1soft.springdemo;

import com.f1soft.springdemo.services.NewServices;
import com.f1soft.springdemo.services.WelcomeServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)


public class SpringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);

    }



}
