package com.org.backend.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.org.backend.models.dtos.CustomerLoginByCpfAndPasswordResponseDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"accounts"})
@EqualsAndHashCode(exclude = {"accounts"})
@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"accounts"})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true, length = 20)
	private String cpf;
	@Column(nullable = false, unique = true, length = 20)
	private String rg;
	@Column(nullable = false, unique = true, length = 6)
	private String password;
	@Column(nullable = false, unique = true, length = 20)
	private String telephone;
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false)
	private Integer addressNumber;
	@Column(nullable = false, length = 20)
	private String addressZipCode;
	@Column(nullable = false, length = 50)
	private String address;
	@Column(nullable = false, length = 30)
	private String addressDistrict;
	@Column(nullable = false, length = 30)
	private String addressCity;
	@Column(nullable = false, length = 2)
	private String addressState;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;
	
	public CustomerLoginByCpfAndPasswordResponseDto convertCustomerLoginByCpfAndPasswordResponseDto() {
		CustomerLoginByCpfAndPasswordResponseDto responseDto = new CustomerLoginByCpfAndPasswordResponseDto();
		responseDto.setId(id);
		return responseDto;
	}
}
