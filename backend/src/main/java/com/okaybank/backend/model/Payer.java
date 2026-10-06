package com.okaybank.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Payer {
	@Column(name = "payer_name", length = 100, nullable = false)
	private String name;
	@Column(name = "payer_document", length = 20, nullable = false)
	private String document;
	@Column(name = "payer_institution", length = 50, nullable = false)
	private String institution;
	@Column(name = "payer_account_number", length = 20, nullable = false)
	private String accountNumber;
	@Column(name = "payer_agency_number", length = 20, nullable = false)
	private String agencyNumber;
}
