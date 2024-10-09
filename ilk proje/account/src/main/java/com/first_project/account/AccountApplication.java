package com.first_project.account;

import com.first_project.account.model.Customer;
import com.first_project.account.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
public class AccountApplication {

	private final CustomerRepository customerRepository;

    public AccountApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = customerRepository.save(new Customer(UUID.randomUUID(), "Elif Sude", "Meydan")
				, new HashSet<>());
		System.out.println(customer);
	}
}
