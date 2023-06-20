package com.org.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backend.exceptions.EntityNotFoundException;
import com.org.backend.models.Customer;
import com.org.backend.repositories.CustumerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustumerRepository custumerRepository;
	
	public Customer loginByCpfAndPassword(String cpf, String password) {
		return custumerRepository.findByCpfAndPassword(cpf, password).orElseThrow(() -> {
			return new EntityNotFoundException("cpf and password not find");
		});	
	}
	
	public Customer findByid(String id) {
		return custumerRepository.findById(id).orElseThrow(() -> {
			return new EntityNotFoundException("id not find");
		});	
	}
}
