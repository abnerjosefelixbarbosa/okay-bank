package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AccountView;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.IAccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService implements IAccountGateway {
	private IAccountRepository accountRepository;
	private IAgencyGateway agencyGateway; 
	private ICustomerGateway customerGateway;

	public AccountView create(AccountDTO dto) {
		Account account = new Account(dto);
		validade(account);
		Customer customer = account.getCustomer();
		Agency agency = agencyGateway.getByNumber(dto.agencyNumber());
		account.setAgency(agency);
		customer = customerGateway.save(customer);
		account = accountRepository.save(account);
		return new AccountView(account);
	}
	
	private void validade(Account account) {		
		boolean existsByCpfOrRgOrEmailOrContactOrPassword = customerGateway.existsByCpfOrRgOrEmailOrContactOrPassword(
				account.getCustomer().getCpf(),
				account.getCustomer().getRg(),
				account.getCustomer().getEmail(),
				account.getCustomer().getContact(),
				account.getCustomer().getPassword()
		);
;		if (existsByCpfOrRgOrEmailOrContactOrPassword) 
			throw new InvalidDataException("customer cpf or rg or email or contact or password exists");
	}
}
