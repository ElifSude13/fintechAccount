package com.firstProject.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.firstProject.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

    
} 