package com.org.back_end_java.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.back_end_java.infra.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {
	boolean existsByNumberAndPassword(String number, String password);
}