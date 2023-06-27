package com.org.backend.interfaces;

import java.util.List;

import com.org.backend.models.Account;

public interface AccountInterface {
	List<Account> listAllByAccount(String id);
	Account findByAgencyAndAccount(String agency, String account);
}
