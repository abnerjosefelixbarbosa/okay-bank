package com.org.backend.interfaces;

import com.org.backend.models.entities.Customer;

public interface CustomerInterface {
	Customer loginByCpfAndPassword(String cpf, String password);
}
