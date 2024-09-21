package com.api.backend_java.infra.service;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.mapper.AccountInfraMapper;
import com.api.backend_java.infra.repository.IAccountRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService implements IAccountGateway {
	private final IAccountRepository accountRepository;
	private final IAgencyGateway agencyGateway;
	private final ICustomerGateway customerGateway;
	private final AccountInfraMapper accountMapper;

	@Transactional
	public AccountDTO create(CreateAccountDTO dto) {
		Account account = accountMapper.toAccount(dto);
		validade(account);
		Agency agency = agencyGateway.getById(account.getAgency().getId());
		Customer customer = customerGateway.getById(account.getCustomer().getId());
		account.setAgency(agency);
		account.setCustomer(customer);
		account = accountRepository.save(account);
		return accountMapper.toAccountDTO(account);
	}

	private void validade(Account account) {
		boolean existsByNumberOrPassword = accountRepository.existsByNumberOrPassword(account.getNumber(),
				account.getPassword());

		if (existsByNumberOrPassword)
			throw new InvalidDataException("number or password exists");
	}
}
