package com.api.backend_java.infra.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.AccountType;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;

@Component
public class AccountInfraMapper {
	public Account toAccount(AccountDTO dto) {
		Customer customer = new Customer(
				dto.customer().id(),
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
		);
		
		Agency agency = new Agency(
				dto.agency().id(),
				null
		);
		
		return new Account(
				null,
				dto.number(),
				BigDecimal.ZERO,
				AccountType.valueOf(dto.accountType().getValue()),
				dto.password(),
				customer,
				agency
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