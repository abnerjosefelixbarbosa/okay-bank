package com.okaybank.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaybank.backend.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, String> {
	boolean existsByNumber(String number);

	Optional<Agency> findByNumber(String number);
}
