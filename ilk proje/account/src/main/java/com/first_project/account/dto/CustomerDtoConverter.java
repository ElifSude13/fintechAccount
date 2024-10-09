package com.first_project.account.dto;

import org.springframework.stereotype.Component;
import com.first_project.account.model.Customer;

import java.util.UUID;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer from) {
        if(from == null){
            return new AccountCustomerDto(UUID.randomUUID(), "", "");
        }
        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
    }
}
