package com.api.backend_java.application;

import org.springframework.stereotype.Component;

import com.api.backend_java.adapter.IAccountGateway;
import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.dto.AccountView;
import com.api.backend_java.domain.usercase.IAccountUsercase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountUsecase implements IAccountUsercase {
	private IAccountGateway accountGateway;

	public AccountView create(AccountDTO dto) {
		AccountView view = accountGateway.create(dto);
		return view;
	}
}
