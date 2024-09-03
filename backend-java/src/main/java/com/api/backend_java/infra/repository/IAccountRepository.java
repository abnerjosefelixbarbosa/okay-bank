package com.api.backend_java.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend_java.infra.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {
	default boolean existsByNumber(String number) {
		return false;
	}
}