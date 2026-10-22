package com.okaybank.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	boolean existsByDocumentOrNameOrEmailOrPhone(String document, String name, String email, String phone);
}
