package com.first_project.account.sevice;

import org.springframework.stereotype.Service;

import com.first_project.account.repository.AccountRepository;

@Service
public class AccountService {
    
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
