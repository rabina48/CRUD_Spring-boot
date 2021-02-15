package com.client.services;

import com.client.multirequest.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ClientServices{

    private RestTemplate restTemplate;
    @Autowired
    public ClientServices(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public String saveBalance( Client client){
        HttpEntity<Client> entity = new HttpEntity<>(client);
        return restTemplate.exchange("http://localhost:8089/transaction/add", HttpMethod.PUT, entity, String.class).getBody();

    }


}
