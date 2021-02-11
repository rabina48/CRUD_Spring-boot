package com.f1soft.springdemo.transactionmanagement.services;


import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.transactionmanagement.profile.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientServices {
    BaseResponse addClient(Client client);
}
