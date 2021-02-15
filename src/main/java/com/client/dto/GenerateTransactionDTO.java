package com.client.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenerateTransactionDTO implements Serializable {

    private Integer threadCount;
    private  Integer transactionCount;


}
