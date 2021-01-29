package com.f1soft.springdemo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Qualifier("UserNoticeService")
@Service
public class UserNoticeService  implements Notice{



    @Override
    public String getNotice() {
        return "User should made Appointment  less then 100 each day!";
    }
}
