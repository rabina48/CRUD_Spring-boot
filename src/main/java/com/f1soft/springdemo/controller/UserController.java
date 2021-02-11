package com.f1soft.springdemo.controller;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.services.Notice;
import com.f1soft.springdemo.services.UserServices;
import com.f1soft.springdemo.services.WelcomeServices;
import com.f1soft.springdemo.user.dto.UserDTO;
import com.f1soft.springdemo.user.UserProfile;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@ApiOperation(value = "/user", tags = " CRUD Controller")
@RequestMapping("user")
public class UserController {



    @Autowired
    private UserServices userServices;

    @Autowired
    private WelcomeServices services;


    @Autowired(required = false)
    @Qualifier("AppointmentNoticeServices")
    private Notice notice;



    //        @PostMapping("/add")

    @PostMapping(path = "add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> addNewUser(@RequestBody UserDTO userDTO) throws InterruptedException {
         BaseResponse userProfileBaseResponse = userServices.addUser(userDTO);
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
    @ApiOperation(value = "Get All Students In List", response = Iterable.class)
    public BaseResponse getUserById(@PathVariable int id) {
        return userServices.getUserById(id);
    }

//===




    @GetMapping("welcome")
    public  String getWelcomeMessage(){
        return services.getWelcomeMessage();
    }


     @GetMapping("notice")
     public String getNotice(){
        return  notice.getNotice();
     }





     }



///
