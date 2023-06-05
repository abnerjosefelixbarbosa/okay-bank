package com.org.apibancookay.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.apibancookay.models.Account;
import com.org.apibancookay.models.Customer;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Disabled
	public void loginByCpfAndPassword() throws Exception {
		Customer customer = new Customer();
		customer.setCpf("949.612.154-30");
		customer.setPassword("481228");

		mockMvc.perform(post("/accounts/login-by-cpf-and-password")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(customer)))
		.andDo(print())
		.andExpect(status().is(200));
	}

	@Test
	@Disabled
	public void findByAgencyAndAccount() throws Exception {
		Account account = new Account();
		account.setAgency("1568-1");
		account.setAccount("13681-1");

		mockMvc.perform(post("/accounts/find-account-by-agency-and-account").contentType("application/json")
				.content(objectMapper.writeValueAsString(account))).andDo(print()).andExpect(status().is(200));
	}

	@Test
    @Disabled
	public void transferBalance() throws Exception {
		Account account = new Account();
		account.setBalance(new BigDecimal("0.50"));

		mockMvc.perform(put("/accounts/transfer-balance/1/2").contentType("application/json")
				.content(objectMapper.writeValueAsString(account))).andDo(print()).andExpect(status().is(200));
	}
}
