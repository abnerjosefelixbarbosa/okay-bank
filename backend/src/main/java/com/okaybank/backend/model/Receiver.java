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
public class Receiver {
	@Column(name = "receiver_name", length = 100, nullable = false)
	private String name;
	@Column(name = "receiver_document", length = 20, nullable = false)
    private String document;
	@Column(name = "receiver_institution", length = 50, nullable = false)
    private String institution;
	@Column(name = "receiver_account_number", length = 20, nullable = false)
    private String accountNumber;
	@Column(name = "receiver_agency_number", length = 20, nullable = false)
    private String agencyNumber;
}
