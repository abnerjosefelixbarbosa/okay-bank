package com.okaybank.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
