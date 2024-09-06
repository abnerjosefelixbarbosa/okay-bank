package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.CustomerDTO;

public interface ICustomerGateway {
	CustomerDTO create(CustomerDTO dto);
}
