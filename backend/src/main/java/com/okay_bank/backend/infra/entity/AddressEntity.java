package com.okay_bank.backend.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddressEntity {
	@Column(name = "address_postal_code", nullable = false)
	private String postalCode;
	@Column(name = "address_name", nullable = false)
    private String name;
	@Column(name = "address_number", nullable = false)
    private Integer number;
	@Column(name = "address_district", nullable = false)
    private String district;
	@Column(name = "address_city", nullable = false)
    private String city;
	@Column(name = "address_state", nullable = false)
    private String state;
}
