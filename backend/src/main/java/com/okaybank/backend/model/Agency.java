package com.okaybank.backend.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "agency_tb")
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 20, nullable = false, unique = true)
	private String number;
	@Column(nullable = false)
	private LocalDate creationDate;
	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	private List<Account> accounts;
	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	private List<Employee> employees; 
}
