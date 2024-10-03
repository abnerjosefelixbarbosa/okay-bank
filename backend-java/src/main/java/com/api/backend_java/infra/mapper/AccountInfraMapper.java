package com.api.backend_java.infra.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.AccountType;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;
import com.github.f4b6a3.ulid.UlidCreator;

@Component
public class AccountInfraMapper {
	public Account toAccount(CreateAccountDTO dto) {
		Customer customer = new Customer();
		customer.setId(dto.getCustomerId());

		Agency agency = new Agency();
		agency.setId(dto.getAgencyId());

		Account account = new Account();
		account.setId(UlidCreator.getUlid().toString());
		account.setNumber(dto.getNumber());
		account.setBalance(BigDecimal.ZERO);
		account.setAccountType(AccountType.valueOf(dto.getAccountType().getValue()));
		account.setPassword(dto.getPassword());
		account.setCustomer(customer);
		account.setAgency(agency);

		return account;
	}
	
	public AccountDTO toAccountDTO(Account account) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(account.getCustomer().getId());
		//customerDTO.setName(account.getCustomer().getName());
		//customerDTO.setEmail(account.getCustomer().getEmail());
		//customerDTO.setPassword(account.getCustomer().getPassword());
		//customerDTO.setContact(account.getCustomer().getContact());
		//customerDTO.setCpf(account.getCustomer().getCpf());
		//customerDTO.setRg(account.getCustomer().getRg());
		//customerDTO.setBirthDate(account.getCustomer().getBirthDate());
		//customerDTO.setAddressPostalCode(account.getCustomer().getAddressPostalCode());
		//customerDTO.setAddressNumber(account.getCustomer().getAddressNumber());
		//customerDTO.setAddressName(account.getCustomer().getAddressName());
		//customerDTO.setAddressDistrict(account.getCustomer().getAddressDistrict());
		//customerDTO.setAddressCity(account.getCustomer().getAddressCity());
		//customerDTO.setAddressState(account.getCustomer().getAddressState());

		AgencyDTO agencyDTO = new AgencyDTO();
		agencyDTO.setId(account.getAgency().getId());
		//agencyDTO.setNumber(account.getAgency().getNumber());

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setNumber(account.getNumber());
		accountDTO.setBalance(account.getBalance());
		accountDTO.setAccountType(com.api.backend_java.domain.entity.AccountType.valueOf(account.getAccountType().getValue()));
		accountDTO.setPassword(account.getPassword());
		accountDTO.setCustomer(customerDTO);
		accountDTO.setAgency(agencyDTO);
		
		return accountDTO;
	}
}