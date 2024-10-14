package com.first_project.account.sevice;

import com.first_project.account.dto.AccountDto;
import com.first_project.account.dto.AccountDtoConverter;
import com.first_project.account.dto.CreateAccountRequest;
import com.first_project.account.model.Account;
import com.first_project.account.model.Customer;
import com.first_project.account.model.Transaction;
import org.springframework.stereotype.Service;

import com.first_project.account.repository.AccountRepository;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService {
    
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter convert;
    private final Clock clock;

    public AccountService(AccountRepository accountRepository, CustomerService customerService,
                          AccountDtoConverter convert, Clock clock) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.convert = convert;
        this.clock = clock;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer, createAccountRequest.getInitialCredit(),  getLocalDateTimeNow());
        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(), getLocalDateTimeNow() ,account);
            account.getTransaction().add(transaction);
        }
        return convert.convert(accountRepository.save(account));
    }

    private LocalDateTime getLocalDateTimeNow() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant, Clock.systemDefaultZone().getZone());
    }
}
