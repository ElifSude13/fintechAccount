package com.first_project.account.dto;

import com.first_project.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.transactionDtoConverter = converter;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(
                from.getId(), from.getBalance(),
                from.getTransaction().stream().map(transactionDtoConverter::convert).collect(Collectors.toSet()),
                from.getCreationDate()
        );
    }
}
