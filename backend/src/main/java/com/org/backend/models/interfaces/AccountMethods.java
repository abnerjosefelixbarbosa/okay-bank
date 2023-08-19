package com.org.backend.models.interfaces;

import java.util.List;

import com.org.backend.models.dtos.AccountDto;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountDto;
import com.org.backend.models.dtos.AccountTransferBalanceDto;

public interface AccountMethods {
	AccountDto getById(String id);
	List<AccountDto> getAllByCustomerId(String id);
	AccountDto getByAgencyAndAccount(AccountFindByAgencyAndAccountDto requestDto);
	AccountDto transferBalance(String id1, String id2, AccountTransferBalanceDto requestDto);
}
