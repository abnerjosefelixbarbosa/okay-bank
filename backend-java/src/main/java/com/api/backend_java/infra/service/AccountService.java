package com.api.backend_java.infra.service;

import java.util.stream.Stream;

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
		//account.setPassword(crypt().encode(account.getPassword()));
		account = accountRepository.save(account);
		return accountMapper.toAccountDTO(account);
	}

	public AccountDTO enter(EnterAccountDTO dto) {
		 Account account = accountRepository.findByAgencyNumberAndNumberAndPassword(dto.getAgency(),
		 dto.getAccount(), dto.getPassword())
		 .orElseThrow(() -> new NotFoundException("account not found"));
		//Stream<Account> stream = accountRepository.findAll().parallelStream();		
		//Account account = stream.map((value) -> {
			//if (value.getNumber() == dto.getAccount() && value.getAgency().getNumber() == dto.getAgency() 
					//&& value.getPassword() == dto.getPassword())
				//return value;
			//return null;
		//}).findFirst().orElseThrow(() -> new NotFoundException("account not found"));
		return accountMapper.toAccountDTO(account);
	}

	private void validade(Account account) {
		Stream<Account> stream = accountRepository.findAll().parallelStream();
		boolean existsByNumberOrPassword = stream.anyMatch((value) -> {
			if (crypt().matches(account.getPassword(), value.getPassword())
					|| account.getNumber() == value.getNumber())
				throw new InvalidDataException("password exist");
			return false;
		});
		if (existsByNumberOrPassword)
			throw new InvalidDataException("number or password exists");
	}

	private BCryptPasswordEncoder crypt() {
		return new BCryptPasswordEncoder();
	}
}
