package com.org.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backend.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
