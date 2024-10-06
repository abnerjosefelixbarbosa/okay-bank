package com.api.backend_java.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend_java.infra.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
	Optional<Customer> findByCpfOrRgOrEmailOrContact(String cpf, String rg, String email, String contact);
	Optional<Customer> findByCpfAndPassword(String cpf, String password);
	Optional<Customer> findByPassword(String password);
	Optional<Customer> findByCpf(String cpf);
}
