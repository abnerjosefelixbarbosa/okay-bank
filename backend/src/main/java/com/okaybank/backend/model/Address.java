package com.okaybank.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {
	@Column(name = "postal_code", length = 10, nullable = false)
	private String postalCode;
	@Column(name = "address_name", length = 30, nullable = false)
    private String name;
	@Column(name = "address_number", nullable = false)
    private Integer number;
	@Column(name = "district", length = 30, nullable = false)
    private String district;
	@Column(name = "city", length = 30, nullable = false)
    private String city;
	@Column(name = "state", length = 30, nullable = false)
    private String state;
}
