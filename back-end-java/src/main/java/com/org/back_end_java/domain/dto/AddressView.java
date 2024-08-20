package com.org.back_end_java.domain.dto;

import lombok.Data;

@Data
public class AddressView {
	private String postalCode;
	private String number;
	private String addressName;
	private String district;
	private String city;
	private String state;
}
