package com.f1soft.springdemo.transactionmanagement.controller;


import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.transactionmanagement.profile.Client;
import com.f1soft.springdemo.transactionmanagement.repository.ClientRepository;
import com.f1soft.springdemo.transactionmanagement.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientServices clientServices;

    @GetMapping("all")
    public BaseResponse getAllClient(){
        return  new BaseResponse(200, true, "success",clientRepository.findAll());
    }

    @PutMapping("add")
    public BaseResponse addClient(Client client){
        return  clientServices.addClient(client);
    }




}
