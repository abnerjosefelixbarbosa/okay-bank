package com.org.backend.repositories;

import java.time.LocalDate;
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
			+ " set cm.name = :name"
			+ " where cm.id = :id")
	Integer updateName(String name, String id);
	
	@Modifying
	@Transactional
	@Query("update CustomerModel cm"
			+ " set cm.cpf = :cpf"
			+ " where cm.id = :id")
	Integer updateCpf(String cpf, String id);
	
	@Modifying
	@Transactional
	@Query("update CustomerModel cm"
			+ " set cm.rg = :rg"
			+ " where cm.id = :id")
	Integer updateRg(String rg, String id);
	
	@Modifying
	@Transactional
	@Query("update CustomerModel cm"
			+ " set cm.password = :password"
			+ " where cm.id = :id")
	Integer updatePassword(String password, String id);
	
	@Modifying
	@Transactional
	@Query("update CustomerModel cm"
			+ " set cm.email = :email"
			+ " where cm.id = :id")
	Integer updateEmail(String email, String id);
	
	@Modifying
	@Transactional
	@Query("update CustomerModel cm"
			+ " set cm.telephone = :telephone"
			+ " where cm.id = :id")
	Integer updateTelephone(String telephone, String id);
	
	@Modifying
	@Transactional
	@Query("update CustomerModel cm"
			+ " set cm.birthDate = :birthDate"
			+ " where cm.id = :id")
	Integer updateBirthDate(LocalDate birthDate, String id);
	
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
