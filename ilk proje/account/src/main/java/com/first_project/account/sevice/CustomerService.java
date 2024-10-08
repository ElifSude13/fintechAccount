package com.firstProject.account.sevice;

import org.springframework.stereotype.Service;

import com.firstProject.account.exception.CustomerNotFoundException;
import com.firstProject.account.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(Srting id) {
        return customerRepository.findAllById().orElseThrow(() -> new 
        CustomerNotFoundException("Customer could not find by id: " + id));
    }
}
