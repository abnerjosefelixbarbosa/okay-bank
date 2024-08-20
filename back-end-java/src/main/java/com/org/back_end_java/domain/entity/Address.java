package com.org.back_end_java.domain.entity;

import lombok.Data;

@Data
public class Address {
	private String postalCode;
	private String number;
	private String addressName;
	private String district;
	private String city;
	private String state;
}
