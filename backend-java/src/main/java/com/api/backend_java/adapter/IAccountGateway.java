package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;

public interface IAccountGateway {
	AccountDTO create(CreateAccountDTO dto);
}
