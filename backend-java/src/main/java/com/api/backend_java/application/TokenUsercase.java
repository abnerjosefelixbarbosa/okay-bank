package com.api.backend_java.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.ITokenGateway;
import com.api.backend_java.domain.usercase.ITokenUsercase;
import com.api.backend_java.infra.entity.Customer;

@Component
public class TokenUsercase implements ITokenUsercase {
	@Autowired
	private ITokenGateway tokenGateway;

	public String generateToken(Customer dto) {
		return tokenGateway.generateToken(dto);
	}

	public String validateToken(String token) {
		return tokenGateway.validateToken(token);
	}
}