package com.org.backend.interfaces;

import java.util.List;

import com.org.backend.models.CustomerModel;

public interface CustomerMethods {
	List<CustomerModel> findAll();

	CustomerModel findById(String id);

	String save(CustomerModel customerModel);
}
