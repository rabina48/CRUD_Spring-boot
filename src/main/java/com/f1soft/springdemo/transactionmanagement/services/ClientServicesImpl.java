package com.f1soft.springdemo.transactionmanagement.services;

import com.f1soft.springdemo.responses.BaseResponse;
import com.f1soft.springdemo.transactionmanagement.profile.Client;
import com.f1soft.springdemo.transactionmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientServicesImpl implements ClientServices{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public BaseResponse addClient(Client client) {

        Client client1 = new Client();
        client1.setId(client.getId());
        client1.setName(client.getName());
        client1.setOpeningBalance(client.getOpeningBalance());
        client1.setStatus(client.isStatus());


        return new BaseResponse(200,true,"Success",clientRepository.save(client1));
    }
}
