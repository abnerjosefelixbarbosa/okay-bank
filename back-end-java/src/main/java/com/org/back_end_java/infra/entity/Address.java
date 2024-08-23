package com.org.back_end_java.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column(nullable = false)
	private String postalCode;
	@Column(nullable = false)
	private String number;
	@Column(name = "address_name", nullable = false)
	private String name;
	@Column(nullable = false)
	private String district;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
}