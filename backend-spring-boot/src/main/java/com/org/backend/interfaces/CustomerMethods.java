package com.org.backend.interfaces;

import java.util.List;
import java.util.UUID;

import com.org.backend.models.CustomerModel;

public interface CustomerMethods {
	List<CustomerModel> findAll();
	CustomerModel findById(UUID id);
	String save(CustomerModel customerModel);
	String update(UUID id, CustomerModel customerModel);
}
