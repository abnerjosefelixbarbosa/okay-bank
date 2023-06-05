package com.org.apibancookay.dtos;

import java.io.Serializable;

import com.org.apibancookay.models.Customer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"customer"})
@EqualsAndHashCode(exclude = {"number", "zipCode", "address", "neighborhood", "city", "state", "customer"})
public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer number;
	private String zipCode;
	private String address;
	private String neighborhood;
	private String city;
	private String state;
	private Customer customer;
}
