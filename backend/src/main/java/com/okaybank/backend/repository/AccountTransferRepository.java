package com.okaybank.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.AccountTransfer;

@Repository
public interface AccountTransferRepository extends JpaRepository<AccountTransfer, String> {

}
