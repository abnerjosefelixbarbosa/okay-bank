package com.api.backend_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.api.backend_java.domain.dto.ConfirmeAccountDTO;
import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.domain.dto.EnterAccountDTO;
import com.api.backend_java.domain.entity.AccountType;
import com.api.backend_java.infra.entity.Account;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.IAccountRepository;
import com.api.backend_java.infra.repository.IAgencyRepository;
import com.api.backend_java.infra.repository.ICustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.f4b6a3.ulid.UlidCreator;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "dev")
class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMappe;
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IAgencyRepository agencyRepository;
	@Autowired
	private IAccountRepository accountRepository;
	private Customer customer = new Customer();
	private Agency agency = new Agency();
	private Account account = new Account();

	@BeforeEach
	void setUp() {
		accountRepository.deleteAll();
		customerRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		accountRepository.deleteAll();
		customerRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	@Test
	@DisplayName("should return 201 and return account")
	void createCase1() throws Exception {
		loadAgency();
		loadCustomer();

		CreateAccountDTO dto = new CreateAccountDTO();
		dto.setNumber("111111");
		dto.setAccountType(AccountType.SAVINGS);
		dto.setPassword("111111");
		dto.setAgencyId(this.agency.getId());
		dto.setCustomerId(this.customer.getId());
		String json = objectMappe.writeValueAsString(dto);

		mockMvc.perform(post("/accounts/create").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated()).andDo(print());
	}

	@Test
	@DisplayName("should return 200 and return account")
	void enterCase1() throws Exception {
		loadAgency();
		loadCustomer();
		loadAccount();

		EnterAccountDTO dto = new EnterAccountDTO();
		dto.setAccount(this.account.getNumber());
		dto.setAgency(this.agency.getNumber());
		dto.setPassword("111111");
		String json = objectMappe.writeValueAsString(dto);

		mockMvc.perform(post("/accounts/enter").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	@DisplayName("should return 200 and return respose")
	void confirmeCase1() throws Exception {
		loadAgency();
		loadCustomer();
		loadAccount();

		ConfirmeAccountDTO dto = new ConfirmeAccountDTO();
		dto.setPassword("111112");
		String json = objectMappe.writeValueAsString(dto);

		mockMvc.perform(post("/accounts/confirme").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andDo(print());
	}

	void loadAccount() {
		Account account = new Account();
		account.setId(UlidCreator.getUlid().toString());
		account.setBalance(BigDecimal.ZERO);
		account.setAccountType(com.api.backend_java.infra.entity.AccountType.SAVINGS);
		account.setAgency(this.agency);
		account.setCustomer(this.customer);
		account.setNumber("111111");
		account.setPassword(crypt().encode("111111"));

		this.account = accountRepository.save(account);
	}

	void loadAgency() {
		Agency agency = new Agency();
		agency.setId(UlidCreator.getUlid().toString());
		agency.setNumber("11111");

		this.agency = agencyRepository.save(agency);
	}

	void loadCustomer() {
		Customer customer = new Customer();
		customer.setId(UlidCreator.getUlid().toString());
		customer.setName("name1");
		customer.setEmail("email1@gmail.com");
		customer.setPassword(crypt().encode("11111111"));
		customer.setContact("81911111111");
		customer.setCpf("36896983086");
		customer.setRg("11111");
		customer.setBirthDate(LocalDate.of(1990, 11, 11));
		customer.setAddressPostalCode("11111");
		customer.setAddressNumber("1");
		customer.setAddressName("name1");
		customer.setAddressDistrict("district1");
		customer.setAddressCity("city1");
		customer.setAddressState("state1");

		this.customer = customerRepository.save(customer);
	}

	BCryptPasswordEncoder crypt() {
		return new BCryptPasswordEncoder();
	}
}