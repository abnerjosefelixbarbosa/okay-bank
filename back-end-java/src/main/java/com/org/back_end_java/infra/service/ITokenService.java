package com.org.back_end_java.infra.service;

import com.org.back_end_java.infra.entity.Customer;

public interface ITokenService {
	public String generateToken(Customer customer);
	public String validateToken(String token);
}
