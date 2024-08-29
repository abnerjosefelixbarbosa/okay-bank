package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AccountView;

public interface IAccountUsercase {
	AccountView create(AccountDTO dto);
}
