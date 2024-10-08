package com.firstProject.account.sevice;

import org.springframework.stereotype.Service;
import com.firstProject.account.repository.AccountRepository;

@Service
public class AccountService {
    
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
