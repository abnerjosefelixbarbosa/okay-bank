package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.CustomerDTO;

public interface ITokenGateway {
	public String generateToken(CustomerDTO dto);
	public String validateToken(String token);
}