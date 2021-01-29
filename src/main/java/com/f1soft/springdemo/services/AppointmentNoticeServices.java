package com.f1soft.springdemo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Qualifier("AppointmentNoticeServices")
@Service
public class AppointmentNoticeServices implements Notice    {



    @Override
    public String getNotice() {
        return "For Appointment your appoint must be less then 100 each day!";
    }
}
