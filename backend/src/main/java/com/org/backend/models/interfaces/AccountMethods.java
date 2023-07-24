package com.org.backend.models.interfaces;

import java.util.List;

import com.org.backend.models.dtos.AccountFindByAgencyAndAccountRequestDto;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountResponseDto;
import com.org.backend.models.dtos.AccountGetAllByIdResponseDto;
import com.org.backend.models.dtos.AccountGetByIdResponseDto;
import com.org.backend.models.dtos.AccountTransferBalanceRequestDto;
import com.org.backend.models.dtos.AccountTransferBalanceResponseDto;

public interface AccountMethods {
	AccountGetByIdResponseDto getById(String id);
	List<AccountGetAllByIdResponseDto> getAllByCustomerId(String id);
	AccountFindByAgencyAndAccountResponseDto findByAgencyAndAccount(AccountFindByAgencyAndAccountRequestDto requestDto);
	AccountTransferBalanceResponseDto transferBalance(String id1, String id2, AccountTransferBalanceRequestDto requestDto);
}
