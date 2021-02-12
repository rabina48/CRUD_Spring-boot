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
    private Integer clientId;
    private Double openingBalance;
    private Double transactionAmount;
    private Double clientClosingBalance;

}


