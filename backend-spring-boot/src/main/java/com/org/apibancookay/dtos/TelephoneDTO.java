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
@EqualsAndHashCode(exclude = {"telephone", "customer"})
public class TelephoneDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String telephone;
	private Customer customer;
}
