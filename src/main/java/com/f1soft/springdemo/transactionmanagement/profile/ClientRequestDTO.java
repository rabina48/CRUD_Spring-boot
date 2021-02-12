package com.f1soft.springdemo.transactionmanagement.profile;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientRequestDTO implements Serializable {

    private Integer clientId;
    private Double amount;
}
