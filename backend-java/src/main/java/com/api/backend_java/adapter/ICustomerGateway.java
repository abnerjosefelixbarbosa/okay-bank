package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.CustomerDTO;

public interface ICustomerGateway {
	boolean existsByCpfOrRgOrEmailOrContactOrPassword(String cpf, String rg, String email, String contact,
			String password);
	CustomerDTO create(CustomerDTO dto);
}
