package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;

public interface IAccountUsercase {
	AccountDTO create(CreateAccountDTO dto);
}
