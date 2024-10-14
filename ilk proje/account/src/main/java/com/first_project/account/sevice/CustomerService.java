package com.first_project.account.sevice;

import com.first_project.account.dto.CustomerDto;
import com.first_project.account.dto.CustomerDtoConverter;
import com.first_project.account.model.Customer;
import org.springframework.stereotype.Service;

import com.first_project.account.exception.CustomerNotFoundException;
import com.first_project.account.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;
    
    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new
        CustomerNotFoundException("Customer could not find by id: " + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(converter::convertToCustomerDto).collect(Collectors.toList());
    }
}
