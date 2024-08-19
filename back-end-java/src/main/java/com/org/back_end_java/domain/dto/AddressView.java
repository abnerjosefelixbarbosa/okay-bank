package com.org.back_end_java.domain.dto;

import lombok.Data;

@Data
public class AddressView {
	private String postalCodeAddress;
	private String numberAddress;
	private String nameAddress;
	private String districtAddress;
	private String cityAddress;
	private String stateAddress;
}
