package com.f1soft.springdemo.transactionmanagement.profile;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long openingBalance;
    private boolean status;


}
