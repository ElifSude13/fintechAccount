package com.first_project.account.sevice;

import com.first_project.account.dto.AccountDto;
import com.first_project.account.dto.AccountDtoConveter;
import com.first_project.account.dto.CreateAccountRequest;
import com.first_project.account.model.Account;
import com.first_project.account.model.Customer;
import com.first_project.account.model.Transaction;
import org.springframework.stereotype.Service;

import com.first_project.account.repository.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConveter conveter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService,
                          TransactionService transactionService, AccountDtoConveter conveter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.conveter = conveter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(customer, createAccountRequest.getInitialCredit(), LocalDateTime.now());
        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){
            //Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransaction().add(transaction);
        }
        return conveter.convert(accountRepository.save(account));
    }
}
