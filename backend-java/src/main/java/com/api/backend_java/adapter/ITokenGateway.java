package com.api.backend_java.adapter;

import com.api.backend_java.infra.entity.Customer;

public interface ITokenGateway {
	public String generateToken(Customer dto);
	public String validateToken(String token);
}