package com.org.backend.models.interfaces;

import com.org.backend.models.dtos.CustomerDto;
import com.org.backend.models.dtos.CustomerLoginByCpfAndPasswordDto;

public interface CustomerMethods {
	CustomerDto loginByCpfAndPassword(CustomerLoginByCpfAndPasswordDto requestDto);
}
