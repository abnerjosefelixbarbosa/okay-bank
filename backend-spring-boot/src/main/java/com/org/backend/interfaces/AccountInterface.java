package com.org.backend.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.org.backend.models.Account;

public interface AccountInterface {
	List<Account> listAllByAccount(String id);
	Account findByAgencyAndAccount(String agency, String account);
	String transferBalance(String id1, String id2, BigDecimal balance);
}
