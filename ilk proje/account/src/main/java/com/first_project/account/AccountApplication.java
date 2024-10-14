package com.first_project.account;

import com.first_project.account.model.Customer;
import com.first_project.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import java.time.Clock;
import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

    public AccountApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public OpenAPI CustomOpenAPI(@Value("${application-description}") String description,
								 @Value("${application-version}") String version){
		return new OpenAPI().info(new Info()
											.title("Account API")
											.version(version)
											.descriptiom(description)
											.license(new License().name("Account API Licence")));
	}

	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}
	@Override
	public void run(String... args) throws Exception {
		Customer customer = customerRepository.save(new Customer("Elif Sude", "Meydan");
		Customer customer2 = customerRepository.save(new Customer("Asiye Merve", "Meydan");
		System.out.println(customer);
		System.out.println(customer2);
	}
}
