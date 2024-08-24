package com.org.back_end_java.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.back_end_java.infra.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
	Optional<Customer> findByCpf(String cpf);
	boolean existsByEmailOrPasswordOrContactOrCpfAndRg(String email, String password, String contact, String cpf, String rg);
}
