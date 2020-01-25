package ru.mercuriev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mercuriev.model.Customer;
import ru.mercuriev.repository.CustomerRepository;

@SpringBootApplication
public class SpringBootCouchbaseApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCouchbaseApplication.class, args);
	}

	@Override
	public void run(String... args) {

		repository.deleteAll();

		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		System.out.println("-------------------------------");
		System.out.println("Customers found with findAll():");
		repository.findAll().forEach(System.out::println);

		System.out.println("--------------------------------");
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("--------------------------------");
		System.out.println("Customers found with findByLastName('Smith'):");
		repository.findByLastName("Smith").forEach(System.out::println);

		System.out.println("--------------------------------");
	}
}
