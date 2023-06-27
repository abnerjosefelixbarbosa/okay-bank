package com.org.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backend.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	List<Account> findByCustomerId(String id);
	Optional<Account> findByAgencyAgencyAndAccount(String agency, String account);
}
