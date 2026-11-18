package com.okay_bank.backend.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String postalCode;
    private String name;
    private Integer number;
    private String district;
    private String city;
    private String state;
}
