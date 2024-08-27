package com.api.backend_java.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend_java.infra.entity.Agency;

@Repository
public interface IAgencyRepository extends JpaRepository<Agency, String> {
	boolean existsByNumber(String number);
}