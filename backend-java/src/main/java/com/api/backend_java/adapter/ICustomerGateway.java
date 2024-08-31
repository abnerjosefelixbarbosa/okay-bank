package com.api.backend_java.adapter;

import com.api.backend_java.infra.entity.Customer;

public interface ICustomerGateway {
	Customer save(Customer customer);
	boolean existsByCpfOrRgOrEmailOrContactOrPassword(String cpf, String rg, String email, String contact,
			String password);
}
