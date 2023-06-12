package com.org.backend.dtos;

import com.org.backend.exceptions.EntityBadRequestException;

import lombok.Data;

@Data
public class CustomerAddressDto {
	private Integer addressNumber;
	private String addressZipCode;
	private String addressName;
	private String addressNeighborhood;
	private String addressCity;
	private String addressState;

	public void validation() {
		if (addressNumber == null || addressNumber == 0)
			throw new EntityBadRequestException("address number is 0");
		if (addressZipCode == null || addressZipCode.isEmpty())
			throw new EntityBadRequestException("address zip code is empty");
		if (addressZipCode.contains(" "))
			throw new EntityBadRequestException("address zip code contains white space");
		if (addressZipCode.length() > 20)
			throw new EntityBadRequestException("address zip code is greater than 20 characters");
		if (addressName == null || addressName.isEmpty())
			throw new EntityBadRequestException("address name is empty");
		if (addressName.length() > 50)
			throw new EntityBadRequestException("address name is greater than 50 characters");
		if (addressNeighborhood == null || addressNeighborhood.isEmpty())
			throw new EntityBadRequestException("address neighborhood is empty");
		if (addressNeighborhood.length() > 30)
			throw new EntityBadRequestException("address neighborhood is greater than 30 characters");
		if (addressCity == null || addressCity.isEmpty())
			throw new EntityBadRequestException("address city is empty");
		if (addressCity.length() > 30)
			throw new EntityBadRequestException("address city is greater than 30 characters");
		if (addressState == null || addressState.isEmpty())
			throw new EntityBadRequestException("address state is empty");
		if (addressState.contains(" "))
			throw new EntityBadRequestException("address state contains white space");
		if (addressState.length() != 2)
			throw new EntityBadRequestException("address state is diferent for 2 characters");
	}
}
