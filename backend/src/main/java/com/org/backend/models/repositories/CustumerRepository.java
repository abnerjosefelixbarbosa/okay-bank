package com.org.backend.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backend.models.entities.Customer;

@Repository
public interface CustumerRepository extends JpaRepository<Customer, String> {
	Optional<Customer> findByCpfAndPassword(String cpf, String password);
}
