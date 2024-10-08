package com.firstProject.account.dto;

import org.springframework.stereotype.Component;
import com.firstProject.account.model.Account;

@Component
public class AccountDtoConveter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConvetrer(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convet(Account from){
        return new AccountDto(from.getId(), from.getBalance(), from.getCreationDate()
        customerDtoConverter.convertToAccountCustomer(from.getCustomer()),
        form.getTransaction().stream().map(t -> transactionDtoConverter.convert(t)).collect(CollectToSet()));
    }
}
 