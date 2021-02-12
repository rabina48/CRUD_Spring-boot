package com.f1soft.springdemo.transactionmanagement.services;

import com.f1soft.springdemo.responses.Response;
import com.f1soft.springdemo.transactionmanagement.profile.Client;
import com.f1soft.springdemo.transactionmanagement.profile.Transaction;
import com.f1soft.springdemo.transactionmanagement.repository.ClientRepository;
import com.f1soft.springdemo.transactionmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {



    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Response deductBalance( Integer clientId, Double transactionAmount) throws Exception {

//
      Client client =  entityManager.find(Client.class, clientId , LockModeType.PESSIMISTIC_WRITE);

      if(client != null && client.getBalance()>100){

          Double openingBalance = client.getBalance();
          Double closingBalance = openingBalance - transactionAmount;

          client.setBalance(closingBalance);

          Transaction transaction = new Transaction();

          transaction.setClientId(clientId);
          transaction.setOpeningBalance(openingBalance);
          transaction.setClientClosingBalance(closingBalance);
          transaction.setTransactionAmount(transactionAmount);

          entityManager.persist(transaction);
          entityManager.persist(client);
          return new Response(200, true, "your remaining balance is "+closingBalance);

      }else {
          return new Response(404, false, "Insufficient balance!");
      }


    }

    @Override
    @Transactional
    public Response addBalance(Integer clientId, Double transactionAmount) {
        Client client =  entityManager.find(Client.class, clientId , LockModeType.PESSIMISTIC_WRITE);

        if(client != null && client.getBalance()>100){

            Double openingBalance = client.getBalance();
            Double closingBalance = openingBalance + transactionAmount;

            client.setBalance(closingBalance);

            Transaction transaction = new Transaction();

            transaction.setClientId(clientId);
            transaction.setOpeningBalance(openingBalance);
            transaction.setClientClosingBalance(closingBalance);
            transaction.setTransactionAmount(transactionAmount);

            entityManager.persist(transaction);
            entityManager.persist(client);
            return new Response(200, true, "your remaining balance is "+closingBalance);

        }else {
            return new Response(404, false, "Insufficient balance!");
        }
    }
}


//