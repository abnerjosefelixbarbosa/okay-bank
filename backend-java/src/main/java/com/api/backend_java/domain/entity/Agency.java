package com.api.backend_java.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agency {
	private String id;
	private String number;
	
	public Agency(String id) {
		this.id = id;
	}
}
