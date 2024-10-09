package com.first_project.account.sevice;

import com.first_project.account.model.Customer;
import org.springframework.stereotype.Service;

import com.first_project.account.exception.CustomerNotFoundException;
import com.first_project.account.repository.CustomerRepository;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new
        CustomerNotFoundException("Customer could not find by id: " + id));
    }
}
