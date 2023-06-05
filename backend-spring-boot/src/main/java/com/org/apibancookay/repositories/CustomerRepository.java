package com.org.apibancookay.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.apibancookay.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("select customer from Customer customer")
	Page<?> getCustomers(Pageable pageable);
	Optional<Customer> findByCpfAndPassword(String cpf, String password);
}
