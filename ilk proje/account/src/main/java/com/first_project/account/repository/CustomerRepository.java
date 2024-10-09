package com.first_project.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first_project.account.model.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID
        >{

    
} 