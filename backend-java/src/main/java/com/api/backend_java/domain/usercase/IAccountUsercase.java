package com.api.backend_java.domain.usercase;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.ConfirmeAccountDTO;
import com.api.backend_java.domain.dto.ConfirmeResponseDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.EnterAccountDTO;
import com.api.backend_java.domain.dto.TransferAccountDTO;
import com.api.backend_java.domain.dto.TransferenceDTO;

public interface IAccountUsercase {
	AccountDTO create(CreateAccountDTO dto);
	AccountDTO enter(EnterAccountDTO dto);
	TransferenceDTO transfer(String accountId, TransferAccountDTO dto);
	ConfirmeResponseDTO confirme(ConfirmeAccountDTO dto);
}