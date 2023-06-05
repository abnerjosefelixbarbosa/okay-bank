package com.org.apibancookay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.apibancookay.models.Account;
import com.org.apibancookay.models.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByCustomer(Customer customer);	
	Optional<Account> findByAgencyAndAccount(String agency, String account);
}
