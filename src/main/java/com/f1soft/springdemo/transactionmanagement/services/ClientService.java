package com.f1soft.springdemo.transactionmanagement.services;

import com.f1soft.springdemo.responses.Response;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    Response deductBalance(Integer clientId,  Double transactionAmount) throws Exception;

    Response addBalance(Integer clientId, Double transactionAmount);
}
