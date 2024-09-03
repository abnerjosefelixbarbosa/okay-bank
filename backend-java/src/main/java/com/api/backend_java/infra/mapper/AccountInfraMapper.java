package com.api.backend_java.infra.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.AccountType;

@Component
public class AccountInfraMapper {
	public Account toAccount(AccountDTO dto) {
		return new Account(
				dto.id(),
				dto.number(),
				BigDecimal.ZERO,
				AccountType.valueOf(dto.accountType().getValue()),
				dto.password(),
				null,
				null
	    );
	}
	
	public AccountDTO toAccountDTO(Account account) {
		CustomerDTO customerDTO = new CustomerDTO(
				account.getCustomer().getId(),
				account.getCustomer().getName(),
				account.getCustomer().getEmail(),
				account.getCustomer().getPassword(),
				account.getCustomer().getContact(),
				account.getCustomer().getCpf(),
				account.getCustomer().getRg(),
				account.getCustomer().getBirthDate(),
				account.getCustomer().getAddressPostalCode(),
				account.getCustomer().getAddressNumber(),
				account.getCustomer().getAddressName(),
				account.getCustomer().getAddressDistrict(),
				account.getCustomer().getAddressCity(),
				account.getCustomer().getAddressState()
		);
		
		AgencyDTO agencyDTO = new AgencyDTO(
				account.getAgency().getId(),
				account.getAgency().getNumber()
		);
		
		return new AccountDTO(
				account.getId(),
				account.getNumber(),
				account.getBalance(),
				com.api.backend_java.domain.entity.AccountType.valueOf(account.getAccountType().getValue()),
				account.getPassword(),
				customerDTO,
				agencyDTO
		);
	}
}