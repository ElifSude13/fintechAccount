package com.first_project.account.dto;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.first_project.account.model.Account;

@Component
public class AccountDtoConveter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConveter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from){
        return new AccountDto(
                from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertToAccountCustomer(Optional.ofNullable(from.getCustomer())),
                Objects.requireNonNull(from.getTransaction())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }
}
 