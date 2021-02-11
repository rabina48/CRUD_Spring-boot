package com.f1soft.springdemo.transactionmanagement.repository;


import com.f1soft.springdemo.transactionmanagement.profile.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
