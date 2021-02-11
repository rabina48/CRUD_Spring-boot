package com.f1soft.springdemo.transactionmanagement.profile;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "transaction")

public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clientId;
    private Long openingBalance;
    private Long transactionAmount;
    private Long clientClosingBalance;

}


// client -> id, name , ba