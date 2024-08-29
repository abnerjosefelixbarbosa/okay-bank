package com.api.backend_java.infra.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AccountView;
import com.api.backend_java.domain.entity.AccountDomainType;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.AccountType;
import com.api.backend_java.infra.entity.Address;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;



@Component
public class AccountInfraMapper {
	public AccountView toAccountView(Account account) {
		AccountView view = new AccountView(account.getId(), account.getNumber(), account.getBalance(),
				account.getPassword(), AccountDomainType.valueOf(account.getAccountType().getValue()),
				account.getAgency().getId(), account.getAgency().getNumber(), account.getCustomer().getId(),
				account.getCustomer().getCpf(), account.getCustomer().getRg(), account.getCustomer().getName(),
				account.getCustomer().getEmail(), account.getCustomer().getContact(),
				account.getCustomer().getContact(), account.getCustomer().getBirthDate(),
				account.getCustomer().getAddress().getPostalCode(), account.getCustomer().getAddress().getNumber(),
				account.getCustomer().getAddress().getName(), account.getCustomer().getAddress().getDistrict(),
				account.getCustomer().getAddress().getState(), account.getCustomer().getAddress().getCity());
		return view;
	}

	public Account toAccount(AccountDTO dto) {
		Agency agency = new Agency(null, dto.agencyNumber());
		Address address = new Address(dto.addressPostalCode(), dto.addressNumber(), dto.addressName(),
				dto.addressDistrict(), dto.addressState(), dto.addressCity());
		Customer customer = new Customer(null, dto.customerCpf(), dto.customerRg(), dto.customerName(),
				dto.customerEmail(), dto.customerContact(), dto.customerPassword(), dto.customerBirthDate(), address);
		Account account = new Account(null, dto.accountNumber(), BigDecimal.valueOf(0), dto.accountPassword(),
				AccountType.INCOME, agency, customer);
		return account;
	}
}