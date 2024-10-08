package com.firstProject.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.firstProject.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

    
} 