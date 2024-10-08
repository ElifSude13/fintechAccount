package com.firstProject.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.firstProject.account.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{
    
}
