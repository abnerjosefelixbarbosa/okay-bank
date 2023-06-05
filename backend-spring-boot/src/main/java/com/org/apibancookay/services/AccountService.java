package com.org.apibancookay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.apibancookay.interfaces.AccountMethod;
import com.org.apibancookay.interfaces.CustomerMethod;
import com.org.apibancookay.models.Account;
import com.org.apibancookay.models.Customer;
import com.org.apibancookay.repositories.AccountRepository;

import br.com.caelum.stella.validation.CPFValidator;

@Service
public class AccountService implements AccountMethod {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerMethod customerMethod;

	private boolean validCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		String newCpf = cpf.replace(".", "").replace("-", "");

		try {
			cpfValidator.assertValid(newCpf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Account loginByCpfAndPassword(Customer customer) throws Exception {
		if (!validCpf(customer.getCpf())) {
			throw new Exception("cpf invalido");
		}
		if (customer.getPassword().isEmpty() || customer.getPassword().length() != 6) {
			throw new Exception("senha invalida");
		}

		Customer customerFound = customerMethod.findByCpfAndPassword(customer);
		Account accountFound = accountRepository.findByCustomer(customerFound).orElse(null);
		if (accountFound == null) {
			return null;
		}

		return accountFound;
	}

	public Account findByAgencyAndAccount(Account account) throws Exception {
		if (account.getAgency().isEmpty() || account.getAgency().length() != 6) {
			throw new Exception("agência invalida");
		}
		if (account.getAccount().isEmpty() || account.getAccount().length() != 7) {
			throw new Exception("conta invalida");
		}

		Account accountFound = accountRepository.findByAgencyAndAccount(account.getAgency(), account.getAccount())
				.orElse(null);
		if (accountFound == null) {
			return accountFound;
		}

		return accountFound;
	}

	public String transferBalance(Long id1, Long id2, Account account) throws Exception {
		if (id1 == id2) {
			throw new Exception("ids iguais");
		}
		if (account.getBalance().doubleValue() == 0) {
			throw new Exception("saldo invalido");
		}

		Account accountFound1 = accountRepository.findById(id1).orElse(null);
		if (accountFound1 == null) {
			return "conta 1 não encontrada";
		}

		Account accountFound2 = accountRepository.findById(id2).orElse(null);
		if (accountFound2 == null) {
			return "conta 2 não encontrada";
		}

		accountFound1.withdraw(account.getBalance());
		accountFound2.deposit(account.getBalance());
		accountRepository.save(accountFound1);
		accountRepository.save(accountFound2);
		return "saldo transferido";
	}
}
