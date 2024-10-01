package com.api.backend_java.domain.usercase;

import com.api.backend_java.infra.entity.Customer;

public interface ITokenUsercase {
	public String generateToken(Customer customer);
	public String validateToken(String token);
}