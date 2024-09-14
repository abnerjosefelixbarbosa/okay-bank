package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginDTO;
import com.api.backend_java.infra.entity.Customer;

public interface ICustomerGateway {
	CustomerDTO create(CustomerDTO dto);
	Customer getById(String id);
	CustomerDTO login(LoginDTO dto);
}
