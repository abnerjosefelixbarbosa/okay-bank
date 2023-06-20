package com.org.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backend.models.Account;
import com.org.backend.models.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	List<Account> findByCustomer(Customer customer);
}
