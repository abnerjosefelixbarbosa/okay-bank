package com.org.back_end_java.adapter;

import com.org.back_end_java.domain.dto.RegisterCustomerDTO;

public interface ICustomerGateway {
	String register(RegisterCustomerDTO dto);
}
