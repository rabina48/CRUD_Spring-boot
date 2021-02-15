package com.client.multirequest;

import com.client.dto.ClientRequestDTO;
import com.client.executorsDemo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

@Service
public class PoolServices implements Callable<Response> {

    private Double amount;
    private Boolean mode;

    public void init(Double amount, Boolean mode) {
        this.amount = amount;
        this.mode = mode;
    }

    @Override
    public Response call() throws Exception {
        System.out.println("current Thread is = " +Thread.currentThread().getName());
        RestTemplate restTemplate = new RestTemplate();
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();



        clientRequestDTO.setClientId(4);
        clientRequestDTO.setAmount(amount);
        HttpEntity<ClientRequestDTO> request = new HttpEntity<>(clientRequestDTO);

        ResponseEntity<Response> response = restTemplate
                .exchange("http://localhost:8089/transaction/"+(mode.booleanValue()?"add":"deduct"), HttpMethod.PUT, request, Response.class);

      return response.getBody();
    }


}
