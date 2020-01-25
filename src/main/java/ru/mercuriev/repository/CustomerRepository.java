package ru.mercuriev.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import ru.mercuriev.model.Customer;

import java.util.List;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "customer")
public interface CustomerRepository extends CouchbasePagingAndSortingRepository<Customer, String> {

	Customer findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);
}