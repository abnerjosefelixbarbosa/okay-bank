package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AccountView;

public interface IAccountGateway {
	AccountView create(AccountDTO dto);
}
