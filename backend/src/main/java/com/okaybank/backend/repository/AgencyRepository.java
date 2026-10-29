package com.okaybank.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, String> {

}
