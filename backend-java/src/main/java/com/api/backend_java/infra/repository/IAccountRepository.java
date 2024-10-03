package com.api.backend_java.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend_java.infra.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {
	boolean existsByNumberOrPassword(String number, String password);
	Optional<Account> findByAgencyNumberAndNumberAndPassword(String agency, String account, String password);
}