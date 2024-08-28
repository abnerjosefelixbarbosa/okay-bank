package com.api.backend_java.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend_java.infra.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

}
