package com.org.back_end_java.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column(nullable = false, length = 20)
	private String postalCodeAddress;
	@Column(nullable = false, length = 10)
	private String numberAddress;
	@Column(nullable = false, length = 50)
	private String nameAddress;
	@Column(nullable = false, length = 30)
	private String districtAddress;
	@Column(nullable = false, length = 30)
	private String cityAddress;
	@Column(nullable = false, length = 30)
	private String stateAddress;
}