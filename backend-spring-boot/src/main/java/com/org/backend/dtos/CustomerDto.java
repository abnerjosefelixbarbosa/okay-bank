package com.org.backend.dtos;

import java.time.LocalDate;

import com.org.backend.exceptions.EntityBadRequestException;

import br.com.caelum.stella.validation.CPFValidator;
import jakarta.mail.internet.InternetAddress;
import lombok.Data;

@Data
public class CustomerDto {
	private String name;
	private String cpf;
	private String rg;
	private String password;
	private String email;
	private String telephone;
	private LocalDate birthDate;
	private Integer addressNumber;
	private String addressZipCode;
	private String addressName;
	private String addressNeighborhood;
	private String addressCity;
	private String addressState;

	public void validateSave() {
		if (name == null || name.isEmpty())
			throw new EntityBadRequestException("name is empty");
		if (name.length() > 100)
			throw new EntityBadRequestException("name is greater than 100 characters");
		if (!validCpf(cpf))
			throw new EntityBadRequestException("cpf is invalid");
		if (rg == null || rg.isEmpty())
			throw new EntityBadRequestException("rg is empty");
		if (rg.contains(" "))
			throw new EntityBadRequestException("rg contains white space");
		if (rg.length() > 20)
			throw new EntityBadRequestException("rg is greater than 20 characters");
		if (password == null || password.length() != 6)
			throw new EntityBadRequestException("password is diferent for 6 characters");
		if (password.contains(" "))
			throw new EntityBadRequestException("password contains white");
		if (!validEmail(email))
			throw new EntityBadRequestException("email is invalid");
		if (email.length() > 50)
			throw new EntityBadRequestException("email is greater than 50 characters");
		if (telephone == null || telephone.isEmpty())
			throw new EntityBadRequestException("telephone is empty");
		if (telephone.length() > 20)
			throw new EntityBadRequestException("telephone is greater than 20 characters");
		if (birthDate == null)
			throw new EntityBadRequestException("birth date is null");
		var localDate = LocalDate.now();
		var yearCalculated = localDate.getYear() - birthDate.getYear();
		if (birthDate.isAfter(localDate) || yearCalculated < 18 || birthDate.getYear() < 1950)
			throw new EntityBadRequestException("birth date invalid");
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
	
	public void validateUpdateName() {
		if (name == null || name.isEmpty())
			throw new EntityBadRequestException("name is empty");
		if (name.length() > 100)
			throw new EntityBadRequestException("name is greater than 100 characters");
	}
	
	public void validateUpdateTelephone() {
		if (telephone == null || telephone.isEmpty())
			throw new EntityBadRequestException("telephone is empty");
		if (telephone.length() > 20)
			throw new EntityBadRequestException("telephone is greater than 20 characters");
	}
	
	public void validateUpdateAddress() {
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
	
	public void validateUpdateEmail() {
		if (!validEmail(email))
			throw new EntityBadRequestException("email is invalid");
		if (email.length() > 50)
			throw new EntityBadRequestException("email is greater than 50 characters");
	}

	private boolean validCpf(String cpf) {
		try {
			CPFValidator cpfValidator = new CPFValidator();
			String newCpf = cpf.replace(".", "").replace("-", "");
			cpfValidator.assertValid(newCpf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean validEmail(String email) {
		try {
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
