package com.f1soft.springdemo.services;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.user.AppointmentProfile;
import com.f1soft.springdemo.user.UserDTO;
import com.f1soft.springdemo.user.UserProfile;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public interface UserServices {
    BaseResponse addUser(UserDTO user) throws InterruptedException;

    BaseResponse update(int userId, UserProfile userProfile);

    Response deleteById(int userId);

    BaseResponse getAllUser();

    BaseResponse getUserById(int id);
}
