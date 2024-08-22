package com.org.back_end_java.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.infra.entity.Account;
import com.org.back_end_java.infra.entity.Agency;
import com.org.back_end_java.infra.entity.Customer;
import com.org.back_end_java.infra.mapper.AccountMapper;
import com.org.back_end_java.infra.mapper.AgencyMapper;
import com.org.back_end_java.infra.mapper.CustomerMapper;
import com.org.back_end_java.infra.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IAgencyService agencyService;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private AgencyMapper agencyMapper;
	
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByCpf(cpf)
				.orElseThrow(() -> new UsernameNotFoundException("customer not found"));
		return customer;
	}

	public String register(RegisterCustomerDTO dto) {
		Customer customer = customerMapper.toCustomer(dto);
		Account account = accountMapper.toAccount(dto);
		Agency agency = agencyMapper.toAgency(dto);
		
		customer = customerRepository.save(customer);
		agency = agencyService.save(agency);
		account.setAgency(agency);
		account.setCustomer(customer);
		account = accountService.save(account);
		
		System.out.println(account.toString());
	
		return "registrado com sucesso";
	}
}
