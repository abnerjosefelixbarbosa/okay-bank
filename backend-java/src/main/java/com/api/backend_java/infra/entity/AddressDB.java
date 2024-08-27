package com.api.backend_java.infra.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 10)
	private String postalCode;
	@Column(nullable = false, length = 4)
	private String number;
	@Column(name = "address", nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 30)
	private String district;
	@Column(nullable = false, length = 30)
	private String state;
	@Column(nullable = false, length = 30)
	private String city;
}