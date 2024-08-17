package com.org.back_end_java.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column(nullable = false)
	private String postalCodeAddress;
	@Column(nullable = false)
	private String numberAddress;
	@Column(nullable = false)
	private String nameAddress;
	@Column(nullable = false)
	private String districtAddress;
	@Column(nullable = false)
	private String cityAddress;
	@Column(nullable = false)
	private String stateAddress;
}