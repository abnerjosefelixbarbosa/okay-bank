package com.org.backend.interfaces;

import java.util.List;

import com.org.backend.models.CustomerModel;

public interface CustomerMethods {
	List<CustomerModel> findAll();

	CustomerModel findById(String id);

	String save(CustomerModel customerModel);

	//String update(String id, CustomerModel customerModel);
	
	String updateName(String id, CustomerModel customerModel);
	
	//String updateCpf(String id, CustomerModel customerModel);
	
	//String updateRg(String id, CustomerModel customerModel);
	
	//String updatePassword(String id, CustomerModel customerModel);
	
	//String updateEmail(String id, CustomerModel customerModel);
	
	String updateTelephone(String id, CustomerModel customerModel);
	
	//String updateBirthDate(String id, CustomerModel customerModel);

	String updateAddress(String id, CustomerModel customerModel);
}
