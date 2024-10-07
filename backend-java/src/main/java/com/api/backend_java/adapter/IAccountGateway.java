package com.api.backend_java.adapter;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.EnterAccountDTO;
import com.api.backend_java.domain.dto.TransferAccountDTO;

public interface IAccountGateway {
	AccountDTO create(CreateAccountDTO dto);
	AccountDTO enter(EnterAccountDTO dto);
	AccountDTO tranfer(String idAccount1, String idAccount2, TransferAccountDTO dto);
}
