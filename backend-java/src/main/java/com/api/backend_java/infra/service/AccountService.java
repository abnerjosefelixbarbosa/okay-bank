package com.api.backend_java.infra.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.adapter.IAgencyGateway;
import com.api.backend_java.adapter.ICustomerGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.EnterAccountDTO;
import com.api.backend_java.domain.exception.InvalidDataException;
import com.api.backend_java.domain.exception.NotFoundException;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.mapper.AccountInfraMapper;
import com.api.backend_java.infra.repository.IAccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService implements IAccountGateway {
	@Autowired
	private IAccountRepository accountRepository;
	@Autowired
	private IAgencyGateway agencyGateway;
	@Autowired
	private ICustomerGateway customerGateway;
	@Autowired
	private AccountInfraMapper accountMapper;

	@Transactional
	public AccountDTO create(CreateAccountDTO dto) {
		Account account = accountMapper.toAccount(dto);
		validade(account);
		Agency agency = agencyGateway.getById(account.getAgency().getId());
		Customer customer = customerGateway.getById(account.getCustomer().getId());
		account.setAgency(agency);
		account.setCustomer(customer);
		account.setPassword(crypt().encode(account.getPassword()));
		account = accountRepository.save(account);
		
		return accountMapper.toAccountDTO(account);
	}

	public AccountDTO enter(EnterAccountDTO dto) {
		Account account = accountRepository
				.findByAgencyNumberAndNumber(dto.getAgency(), dto.getAccount())
				.orElseThrow(() -> new NotFoundException("account not found"));
		validadePassword(dto.getPassword(), account.getPassword());
		
		return accountMapper.toAccountDTO(account);
	}
	
	private void validadePassword(String password, String encode) {
		if (!crypt().matches(password, encode))
			throw new NotFoundException("account not found");
	}

	private void validade(Account account) {
		Stream<Account> stream = accountRepository
				.findAll()
				.parallelStream();
		boolean exists = stream.anyMatch((value) -> {
			if (account.getNumber() == value.getNumber())
				return true;
			if (crypt().matches(account.getPassword(), value.getPassword()))
				return true;
			
			return false;
		});
		
		if (exists)
			throw new InvalidDataException("password or number exists");
	}

	private BCryptPasswordEncoder crypt() {
		return new BCryptPasswordEncoder();
	}
}
