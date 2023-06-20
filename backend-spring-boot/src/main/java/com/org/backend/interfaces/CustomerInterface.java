package com.org.backend.interfaces;

import com.org.backend.models.Customer;

public interface CustomerInterface {
	Customer findByid(String id);

	Customer findByCpfAndPassword(String cpf, String password);
}
