package com.first_project.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first_project.account.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, String>{

    
} 