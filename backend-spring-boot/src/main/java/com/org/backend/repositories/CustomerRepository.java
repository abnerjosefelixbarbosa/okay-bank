package com.org.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backend.models.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String> {
	List<CustomerModel> findByOrderByName();

	boolean existsByCpf(String cpf);

	boolean existsByRg(String rg);

	boolean existsByPassword(String password);

	boolean existsByEmail(String email);
	
	boolean existsByTelephoneModelTelephone(String telephone);
}
