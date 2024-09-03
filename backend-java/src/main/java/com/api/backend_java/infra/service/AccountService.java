package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.repository.IAccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService implements IAccountGateway {
	private IAccountRepository accountRepository;
	private IAgencyGateway agencyGateway; 
	private ICustomerGateway customerGateway;

	public AccountDTO create(AccountDTO dto) {
		/*
		Account account = new Account(dto);
		validade(account);
		Customer customer = account.getCustomer();
		Agency agency = agencyGateway.getByNumber(dto.agencyNumber());
		account.setAgency(agency);
		customer = customerGateway.save(customer);
		account = accountRepository.save(account);
		*/
		return null;
	}
	
	private void validade(Account account) {		
		boolean existsByCpfOrRgOrEmailOrContactOrPassword = customerGateway.existsByCpfOrRgOrEmailOrContactOrPassword(
				account.getCustomer().getCpf(),
				account.getCustomer().getRg(),
				account.getCustomer().getEmail(),
				account.getCustomer().getContact(),
				account.getCustomer().getPassword()
		);
		boolean existsByNumber = accountRepository.existsByNumber(
				account.getNumber()
		);
		if (existsByNumber)
			throw new InvalidDataException("account number exists");
		if (existsByCpfOrRgOrEmailOrContactOrPassword) 
			throw new InvalidDataException("customer cpf, rg, email, contact or password exists");
	}
}
