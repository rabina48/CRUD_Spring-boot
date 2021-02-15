package com.client.multirequest;

import com.client.dto.GenerateTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@RestController
public class PoolController {
    @Autowired
    private PoolServices poolServices;

    @PostMapping("generateTransaction")
    private void generateTransaction(@RequestBody GenerateTransactionDTO request) throws Exception {

        ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(request.getThreadCount());
        double transaction= 0.0;
        double start = 50;
        double end = 1000;
        double random;
        double amount;
        boolean type;

        for (int i = 1; i <= request.getTransactionCount(); i++) {
            PoolServices poolServices = new PoolServices();
            random = new Random().nextDouble();
            amount = start + (random * (end - start));
            type = new Random().nextBoolean();
            poolServices.init(amount, type);

            if (type) {
                transaction = transaction + amount;


            } else {
                transaction = transaction - amount;
            }

            executor.submit(poolServices);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {


        }

        System.out.println("transaction = "+transaction);
    }
}



