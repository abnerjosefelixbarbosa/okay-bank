package com.org.backend.models.interfaces;

import com.org.backend.models.dtos.CustomerLoginByCpfAndPasswordRequestDto;
import com.org.backend.models.dtos.CustomerLoginByCpfAndPasswordResponseDto;

public interface CustomerMethods {
	CustomerLoginByCpfAndPasswordResponseDto loginByCpfAndPassword(CustomerLoginByCpfAndPasswordRequestDto requestDto);
}
