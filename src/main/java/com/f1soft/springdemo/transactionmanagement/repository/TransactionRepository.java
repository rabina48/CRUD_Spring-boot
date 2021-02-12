package com.f1soft.springdemo.transactionmanagement.repository;

import com.f1soft.springdemo.transactionmanagement.profile.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
