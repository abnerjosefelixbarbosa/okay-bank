package com.org.back_end_java.application;

import org.springframework.stereotype.Component;

import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.domain.usercase.ICustomerUserCase;

@Component
public class CustomerUserCase implements ICustomerUserCase {

	public String register(RegisterCustomerDTO dto) {
		return "registrado com sucesso";
	}
}
