package com.api.backend_java.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend_java.infra.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
	Optional<Customer> findByCpfOrRgOrEmailOrContactOrPassword(String cpf, String rg, String email, String contact, String password);
	Optional<Customer> findByCpfAndPassword(String cpf, String password);
	Optional<Customer> findByPassword(String password);
	Optional<Customer> findByCpf(String cpf);
}
