package com.okay_bank.backend.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransfer {
	private String id;
    private Transfer transfer;
    private Account account;
}
