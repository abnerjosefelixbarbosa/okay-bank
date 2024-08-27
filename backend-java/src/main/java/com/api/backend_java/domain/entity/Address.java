package com.api.backend_java.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String postalCode;
	private String number;
	private String name;
	private String district;
	private String state;
	private String city;
}