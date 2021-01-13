package com.f1soft.springdemo.controller;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.services.UserServices;
import com.f1soft.springdemo.user.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {



    @Autowired
    private UserServices userServices;

    //        @PostMapping("/add")
    @PostMapping(path = "add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> addNewUser(@RequestBody UserProfile userProfile) {
         BaseResponse userProfileBaseResponse = userServices.addUser(userProfile);
        //return ResponseEntity.ok(userProfileBaseResponse);
        return new ResponseEntity<>(userProfileBaseResponse, HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public BaseResponse update(@PathVariable int userId, @RequestBody UserProfile userProfile) {
        return userServices.update(userId, userProfile);
    }

    @DeleteMapping("{userId}")
    public Response delete(@PathVariable int userId) {
        return userServices.deleteById(userId);
    }

    @GetMapping(" ")
    public BaseResponse getAllUser() {
        return userServices.getAllUser(); }


    @GetMapping("{id}")
    public BaseResponse getUserById(@PathVariable int id) {
        return userServices.getUserById(id);
    }


}

