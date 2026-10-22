package com.okaybank.backend.service;

import org.springframework.stereotype.Service;

import com.okaybank.backend.dto.CustomerRequestDTO;
import com.okaybank.backend.dto.CustomerResponseDTO;
import com.okaybank.backend.exception.ApplicationException;
import com.okaybank.backend.mapper.CustomerMapper;
import com.okaybank.backend.model.Customer;
import com.okaybank.backend.repository.CustomerRepository;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImp implements CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerServiceImp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Transactional
	public CustomerResponseDTO registerCustomer(CustomerRequestDTO dto) {
		Customer customer = CustomerMapper.toCustomer(dto);

		validadeCustomer(customer);

		Customer customerSaved = customerRepository.save(customer);

		CustomerResponseDTO respone = CustomerMapper.toDTO(customerSaved);

		return respone;
	}

	private void validadeCustomer(Customer customer) {
		if (customer.getAddress().getNumber() == 0) {
			throw new ApplicationException("Numero do endereço não deve ser 0.");
		}

		if (customer.getCustomerType().name() == "PF") {
			validateCPF(customer.getDocument());
		}

		if (customer.getCustomerType().name() == "PJ") {
			validateCNPJ(customer.getDocument());
		}

		boolean isExistsByDocumentOrNameOrEmailOrPhone = customerRepository.existsByDocumentOrNameOrEmailOrPhone(
				customer.getDocument(), customer.getName(), customer.getEmail(), customer.getPhone());

		if (isExistsByDocumentOrNameOrEmailOrPhone) {
			throw new ApplicationException("Documento, nome, email ou telefone não devem ser repetidos.");
		}
	}

	private void validateCPF(String document) {
		CPFValidator validator = new CPFValidator();
		
		try {
			validator.assertValid(document);
		} catch (Exception e) {
			throw new ApplicationException("Documento CPF deve ser valido.");
		}
	}

	private void validateCNPJ(String document) {
		CNPJValidator validator = new CNPJValidator();
		
		try {
			validator.assertValid(document);
		} catch (Exception e) {
			throw new ApplicationException("Documento CNPJ deve ser valido.");
		}
	}
}
