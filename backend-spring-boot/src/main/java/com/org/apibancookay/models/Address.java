package com.org.apibancookay.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"customer"})
@EqualsAndHashCode(exclude = {"number", "zipCode", "address", "neighborhood", "city", "state", "customer"})
@Entity
@Table(name = "address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	@Column(nullable = false)
	private Integer number;
	@Column(length = 20, nullable = false)
	private String zipCode;
	@Column(length = 100, nullable = false)
	private String address;
	@Column(length = 20, nullable = false)
	private String neighborhood;
	@Column(length = 20, nullable = false)
	private String city;
	@Column(length = 2, nullable = false)
	private String state;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, unique = true)
	private Customer customer;
}
