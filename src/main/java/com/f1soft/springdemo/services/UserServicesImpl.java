package com.f1soft.springdemo.services;


import com.f1soft.springdemo.repository.UserRepository;
import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.user.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service

public class UserServicesImpl implements UserServices {


    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse addUser(UserProfile user) {
        return new BaseResponse(HttpStatus.CREATED.value(),true, "Added Successfully!",userRepository.save(user));
    }

    @Override
    public BaseResponse update(int userId, UserProfile userProfile) {
        return null;
    }

    @Override
    public Response deleteById(int userId) {
        return null;
    }

    @Override
    public BaseResponse getAllUser() {
        return new BaseResponse(200,true, "Successfully!",userRepository.findAll());

    }
}
