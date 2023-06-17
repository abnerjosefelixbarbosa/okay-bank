package com.org.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backend.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	boolean existsByCpf(String cpf);

	boolean existsByRg(String rg);

	boolean existsByPassword(String password);

	boolean existsByEmail(String email);
	
	boolean existsByTelephoneModelTelephone(String telephone);
}
