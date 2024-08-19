package com.org.back_end_java.domain.entity;

import lombok.Data;

@Data
public class Address {
	private String postalCodeAddress;
	private String numberAddress;
	private String nameAddress;
	private String districtAddress;
	private String cityAddress;
	private String stateAddress;
}
