package com.org.backend.models.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.org.backend.models.dtos.AccountFindByAgencyAndAccountRequestDto;
import com.org.backend.models.dtos.AccountFindByAgencyAndAccountResponseDto;
import com.org.backend.models.dtos.AccountGetAllByIdResponseDto;
import com.org.backend.models.dtos.AccountGetByIdResponseDto;

public interface AccountMethods {
	AccountGetByIdResponseDto getById(String id);
	List<AccountGetAllByIdResponseDto> getAllByCustomerId(String id);
	AccountFindByAgencyAndAccountResponseDto findByAgencyAndAccount(AccountFindByAgencyAndAccountRequestDto requestDto);
	String transferBalance(String id1, String id2, BigDecimal balance);
}
