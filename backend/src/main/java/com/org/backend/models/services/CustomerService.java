package com.org.backend.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.controllers.exceptions.EntityNotFoundException;
import com.org.backend.models.dtos.CustomerDto;
import com.org.backend.models.dtos.CustomerLoginByCpfAndPasswordDto;
import com.org.backend.models.interfaces.CustomerMethods;
import com.org.backend.models.repositories.CustumerRepository;

@Service
public class CustomerService implements CustomerMethods {
	@Autowired
	private CustumerRepository custumerRepository;

	public CustomerDto loginByCpfAndPassword(CustomerLoginByCpfAndPasswordDto requestDto) {
	    var customer = custumerRepository.findByCpfAndPassword(requestDto.getCpf(), requestDto.getPassword()).orElseThrow(() -> {
			throw new EntityNotFoundException("CPF and password not find");
		});
	    var responseDto = new CustomerDto();
	    responseDto.loginByCpfAndPassword(customer);
        return responseDto;
	}
}
