package com.okay_bank.backend.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PayerEntity {
	@Column(name = "payer_name", length = 100, nullable = false)
	private String name;
	@Column(name = "payer_document", length = 20, nullable = false)
	private String document;
	@Column(name = "payer_institution", length = 30, nullable = false)
	private String institution;
	@Column(name = "payer_account_number", length = 10, nullable = false)
	private String accountNumber;
	@Column(name = "payer_agency_number", length = 10, nullable = false)
	private String agencyNumber;
}
