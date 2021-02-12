package com.f1soft.springdemo.transactionmanagement.controller;


import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.transactionmanagement.profile.ClientRequestDTO;
import com.f1soft.springdemo.transactionmanagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @PutMapping("deduct")
    private Response deductBalance(@RequestBody ClientRequestDTO request) throws Exception {
        return  clientService.deductBalance(request.getClientId(), request.getAmount());

    }

    @PutMapping("add")
    private Response addBalance(@RequestBody ClientRequestDTO request){
         return  clientService.addBalance(request.getClientId(), request.getAmount());

    }
}


// check the transaction -> available or not
// Transaction -> multiple as well -> use lock here->
//client id - transaction (lock) -> if we withdraw then the system failure ->if exception (Rollback)
// client id 2 + transaction (lock)-> success then
// commit
//-> lock free

//with draw utils (method: account check blnc,  withdarw money should be deduct
// Deposite utils ( method: add money, total amt check

// log log4j -> aspect create -> call before and after transaction method