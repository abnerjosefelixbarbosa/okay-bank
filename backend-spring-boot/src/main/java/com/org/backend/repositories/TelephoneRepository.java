package com.org.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.backend.models.TelephoneModel;

public interface TelephoneRepository extends JpaRepository<TelephoneModel, String> {
	boolean existsByTelephone(String telephone);
}
