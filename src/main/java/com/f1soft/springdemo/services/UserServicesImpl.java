package com.f1soft.springdemo.services;


import com.f1soft.springdemo.logging.TrackExecutionTime;
import com.f1soft.springdemo.repository.AppointmentRepository;
import com.f1soft.springdemo.repository.UserRepository;
import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.user.AppointmentProfile;
import com.f1soft.springdemo.user.UserDTO;
import com.f1soft.springdemo.user.UserProfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


@Service
public class UserServicesImpl implements UserServices {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentServicesImpl appointmentServices;


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    @Transactional(rollbackFor = {IndexOutOfBoundsException.class})
    public BaseResponse addUser(UserDTO userDTO) throws InterruptedException {


        UserProfile userProfile = new UserProfile();
        userProfile.setEmail(userDTO.getEmail());
        userProfile.setFirstName(userDTO.getFirstName());
        userProfile.setLastName(userDTO.getLastName());
        userProfile.setPhone(userDTO.getPhone());
        userProfile.setPassword(userDTO.getPassword());

        UserProfile dataa = userRepository.save(userProfile);

        AppointmentProfile appointmentProfile = new AppointmentProfile();

        appointmentProfile.setDatee(new Date());

        appointmentProfile.setAppointNo(userDTO.getProfile().getAppointNo());

        appointmentRepository.save(appointmentProfile);

        Thread.sleep(20000);


       if (userDTO.getProfile().getAppointNo() >= 100) {
            throw new IndexOutOfBoundsException("Please visit tommorrow");
       } else {

           return new BaseResponse(HttpStatus.CREATED.value(), true, "Added Successfully!",userRepository.save(userProfile));
        }


//        try {
//            int a = 12 / 0;
//
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }

      //  return new BaseResponse(HttpStatus.CREATED.value(), true, "Added Successfully!", userRepository.save(userProfile));

    }

    @Override
    public BaseResponse update(int userId, UserProfile userProfile) {

        Optional<UserProfile> data = userRepository.findById(userId);

        if (data.isPresent()) {

            UserProfile user = data.get();
            user.setFirstName(userProfile.getFirstName());
            user.setLastName(userProfile.getLastName());
            user.setEmail(userProfile.getEmail());
            user.setPhone(userProfile.getPhone());
            user.setPassword(userProfile.getPassword());

            return new BaseResponse(201, true, "updated!", userRepository.save(user));

        } else {

            return new BaseResponse(404, false, "no data!");
        }


    }

    @Override
    public Response deleteById(int userId) {


        Optional<UserProfile> productDb = this.userRepository.findById(userId);
        if (productDb.isPresent()) {
            userRepository.deleteById(userId);

            return new BaseResponse(201, true, "Delete Success!");
        } else {
            return new BaseResponse(404, false, "no data!");
        }

    }

    @Override
    @TrackExecutionTime
    public BaseResponse getAllUser() {
        return new BaseResponse(200, true, "Successfully!", userRepository.findAll());

    }

    @Override
    @TrackExecutionTime
    public BaseResponse getUserById(int id) {
        Optional<UserProfile> productDb = this.userRepository.findById(id);
        if (productDb.isPresent()) {

            return new BaseResponse(201, true, "SUCCESS!!", productDb.get());
        } else {
            return new BaseResponse(404, false, "no data!");
        }

    }
}
