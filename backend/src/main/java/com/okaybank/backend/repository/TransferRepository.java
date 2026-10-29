package com.okaybank.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, String> {

}
