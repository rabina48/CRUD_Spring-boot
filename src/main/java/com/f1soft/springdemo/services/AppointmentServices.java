package com.f1soft.springdemo.services;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.user.AppointmentProfile;
import com.f1soft.springdemo.user.UserProfile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Rabina
 */

@Service
public interface AppointmentServices {

    BaseResponse updateAppointment(int appId, AppointmentProfile profile);

    Response deleteAppointment();

    BaseResponse getAllAppointment();

    BaseResponse appointmentAdd(AppointmentProfile profile);

    Response deleteAppointmentById(int id);
}
