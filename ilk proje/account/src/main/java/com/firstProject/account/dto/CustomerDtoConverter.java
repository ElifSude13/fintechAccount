package com.firstProject.account.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer from) {
        if(from == null){
            return new AccountCustomerDto(id:"", name:"", surname:"")
        }
        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
    }
}
