package com.first_project.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first_project.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

    
} 