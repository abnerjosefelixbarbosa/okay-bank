package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.AccountDTO;

public interface IAccountGateway {
	AccountDTO create(AccountDTO dto);
}
