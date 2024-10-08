package com.first_project.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first_project.account.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{
    
}
