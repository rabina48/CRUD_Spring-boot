package com.f1soft.springdemo.services;

import com.f1soft.springdemo.repository.AppointmentRepository;
import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.user.AppointmentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author Rabina
 */

@Service
public class AppointmentServicesImpl implements AppointmentServices {


    @Autowired
    private AppointmentRepository appointRepository;

    @Override
    public BaseResponse updateAppointment(int appId, AppointmentProfile profile) {
        return null;
    }


    @Scheduled(cron = "0/5 39 16 * * ?")

    //@Scheduled(cron = "0/20 * * * * ?")
    // every 20sec
    @Override
    public Response deleteAppointment() {
        appointRepository.deleteAll();

        return new BaseResponse(200, true, "delete success");
    }

    @Override
    public BaseResponse getAllAppointment() {
        return new BaseResponse(200, true, "Success!", appointRepository.findAll());
    }

    @Override
    @Transactional(rollbackFor = IndexOutOfBoundsException.class)
    public BaseResponse appointmentAdd(AppointmentProfile profile) throws IndexOutOfBoundsException {

        AppointmentProfile data = appointRepository.save(profile);

        if (data.getAppointNo() >= 100) {
            throw new IndexOutOfBoundsException("Please visit tommorrow");
        } else {

            return new BaseResponse(200, true, "Successs added", data);

        }


    }

    @Override
    public Response deleteAppointmentById(int appId) {

        Optional<AppointmentProfile> data = appointRepository.findById(appId);

        if(data.isPresent()){
            return new Response(200, true, "Delete Success!");
        }else{
            return  new Response(404, false, "Data not found!");
        }

    }
}



