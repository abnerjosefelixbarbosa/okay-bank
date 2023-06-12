package com.org.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.backend.models.CustomerModel;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String> {
	@Modifying
	@Transactional
	@Query("update CustomerModel cm"
			+ " set cm.addressNumber = :addressNumber, cm.addressZipCode = :addressZipCode, cm.addressName = :addressName, cm.addressNeighborhood = :addressNeighborhood, cm.addressCity = :addressCity, cm.addressState = :addressState"
			+ " where cm.id = :id")
	Integer updateAddress(Integer addressNumber, String addressZipCode, String addressName,
			String addressNeighborhood, String addressCity, String addressState, String id);

	List<CustomerModel> findByOrderByName();

	boolean existsByCpf(String cpf);

	boolean existsByRg(String rg);

	boolean existsByPassword(String password);

	boolean existsByEmail(String email);

	boolean existsByTelephone(String telephone);
}
