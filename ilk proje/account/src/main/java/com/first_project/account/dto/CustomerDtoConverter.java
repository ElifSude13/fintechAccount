package com.first_project.account.dto;

import org.springframework.stereotype.Component;
import com.firstProject.account.model.Customer;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer from) {
        if(from == null){
            return new AccountCustomerDto(id:"", name:"", surname:"")
        }
        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
    }
}
