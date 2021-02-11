package com.f1soft.springdemo.controller;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.services.AppointmentServices;
import com.f1soft.springdemo.user.AppointmentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rabina
 */
@Configuration
@RestController
@RequestMapping("app")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;



    @PutMapping("{appId}")
    public BaseResponse updateAppointment(@PathVariable int appId, @RequestBody AppointmentProfile profile) {
        return appointmentServices.updateAppointment(appId, profile);
    }

    @DeleteMapping(" ")
    public Response deleteAppointment() {
        return appointmentServices.deleteAppointment();
    }

    @DeleteMapping("{appId}")
    public Response deleteAppointmentById(@PathVariable int appId) {

        return appointmentServices.deleteAppointmentById(appId);
    }

    @GetMapping("all")
    public BaseResponse getAllAppointment() {
        return appointmentServices.getAllAppointment();
    }


    @PostMapping("add")
    public BaseResponse appointmentAdd(@RequestBody AppointmentProfile profile) {
        return appointmentServices.appointmentAdd(profile);
    }
}
