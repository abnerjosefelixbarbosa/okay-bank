package com.okay_bank.backend.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.okay_bank.backend.infra.entity.AgencyEntity;

@Repository
public interface AgencyRepository extends JpaRepository<AgencyEntity, String>, JpaSpecificationExecutor<AgencyEntity> {
	boolean existsByNumber(String number);
}
