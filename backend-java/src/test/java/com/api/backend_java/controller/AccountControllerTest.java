package com.api.backend_java.controller;

import com.api.backend_java.domain.dto.CreateAccountDTO;
import com.api.backend_java.infra.repository.IAccountRepository;
import com.api.backend_java.infra.repository.IAgencyRepository;
import com.api.backend_java.infra.repository.ICustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

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

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        agencyRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
        agencyRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    @DisplayName("should return 201")
    void createCase1() throws Exception {
        CreateAccountDTO dto = new CreateAccountDTO();

    }
}