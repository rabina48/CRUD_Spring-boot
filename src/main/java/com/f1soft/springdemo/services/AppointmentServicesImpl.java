package com.f1soft.springdemo.services;

import com.f1soft.springdemo.repository.AppointmentRepository;
import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.user.AppointmentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Override
    public Response deleteAppointment(int appId) {
        return null;
    }

    @Override
    public BaseResponse getAllAppointment() {
        return new BaseResponse(200, true, "Success!", appointRepository.findAll());
    }

    @Override
    @Transactional(rollbackFor = IndexOutOfBoundsException.class)
    public BaseResponse appointmentAdd(AppointmentProfile profile) throws IndexOutOfBoundsException{

        AppointmentProfile data = appointRepository.save(profile);

        if (data.getAppointNo() >= 100) {
            throw new IndexOutOfBoundsException("Please visit tommorrow");
        } else {

            return new BaseResponse(200, true, "Successs added", data);

        }



    }
}



