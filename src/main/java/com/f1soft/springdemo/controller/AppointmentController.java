package com.f1soft.springdemo.controller;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.services.AppointmentServices;
import com.f1soft.springdemo.user.AppointmentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rabina
 */

@RestController
@RequestMapping("app")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;



    @PutMapping("{appId}")
    public BaseResponse updateAppointment(@PathVariable int appId, @RequestBody AppointmentProfile profile) {
        return appointmentServices.updateAppointment(appId, profile);
    }

    @DeleteMapping("{appId}")
    public Response deleteAppointment(@PathVariable int appId) {

        return appointmentServices.deleteAppointment(appId);
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
