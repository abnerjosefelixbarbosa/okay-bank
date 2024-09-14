package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginDTO;

public interface ICustomerUsercase {
	CustomerDTO create(CustomerDTO dto);
	CustomerDTO login(LoginDTO dto);
}