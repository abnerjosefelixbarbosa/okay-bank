package com.api.backend_java.infra.mapper;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;

@Component
public class AccountInfraMapper {
	public Account toAccount(CreateAccountDTO dto) {
		Customer customer = new Customer(dto);

		Agency agency = new Agency(dto);

		Account account = new Account(dto);
		account.setCustomer(customer);
		account.setAgency(agency);

		return account;
	}
	
	public AccountDTO toAccountDTO(Account account) {
		CustomerDTO customerDTO = new CustomerDTO(account.getCustomer());

		AgencyDTO agencyDTO = new AgencyDTO(account.getAgency());

		AccountDTO accountDTO = new AccountDTO(account);
		accountDTO.setAgency(agencyDTO);
		accountDTO.setCustomer(customerDTO);
		
		return accountDTO;
	}
}