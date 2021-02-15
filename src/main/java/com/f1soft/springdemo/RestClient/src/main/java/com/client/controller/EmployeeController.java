package com.client.controller;

import com.client.multirequest.Client;
import com.client.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class EmployeeController {
    @Autowired
    private ClientServices clientServices;


    @PutMapping("")
    public String saveClientAmount(@RequestBody Client client) {
        return  clientServices.saveBalance(client);

    }
}
