package com.first_project.account.dto;

import org.springframework.stereotype.Component;
import com.first_project.account.model.Customer;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.customerAccountDtoConverter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getId(), Objects.requireNonNull(f.getName())
                , Objects.requireNonNull(f.getSurname()))).orElse(null);
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                Objects.requireNonNull(from.getAccounts()).stream()
                        .map(customerAccountDtoConverter::convert).collect(Collectors.toSet())
        );
    }
}
