package com.first_project.account.repository;

import com.first_project.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String>{
    
}
