package com.org.back_end_java.infra.service;

import com.org.back_end_java.infra.entity.Account;

public interface IAccountService {
	Account save(Account account);
	boolean existsAccount(Account account);
}
