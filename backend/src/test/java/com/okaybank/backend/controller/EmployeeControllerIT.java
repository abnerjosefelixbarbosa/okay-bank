package com.okaybank.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.okaybank.backend.dto.EmployeeRequestDTO;
import com.okaybank.backend.model.Address;
import com.okaybank.backend.model.Agency;
import com.okaybank.backend.model.Employee;
import com.okaybank.backend.model.EmployeeStatus;
import com.okaybank.backend.model.EmployeeType;
import com.okaybank.backend.repository.AgencyRepository;
import com.okaybank.backend.repository.EmployeeRepository;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class EmployeeControllerIT {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private AgencyRepository agencyRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		employeeRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
		employeeRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	// register employee

	@Test
	@DisplayName("Should register employee and return status 201.")
	void registerEmployeeTest1() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		String number = agencyRepository.save(agency).getNumber();

		EmployeeRequestDTO request = new EmployeeRequestDTO("1111111111", LocalDate.now().withYear(1995), "07772613083",
				"Nome1", new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", number);

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	@DisplayName("Should not register employee when salary not has 2 digits and return status 400.")
	void registerEmployeeTest2() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		String number = agencyRepository.save(agency).getNumber();

		EmployeeRequestDTO request = new EmployeeRequestDTO("1111111111", LocalDate.now().withYear(1995), "07772613083",
				"Nome1", new BigDecimal("1500.0"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", number);

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	@Test
	@DisplayName("Should not register employee when salary is 0.00 and return status 400.")
	void registerEmployeeTest3() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		String number = agencyRepository.save(agency).getNumber();

		EmployeeRequestDTO request = new EmployeeRequestDTO("1111111111", LocalDate.now().withYear(1995), "07772613083",
				"Nome1", new BigDecimal("0.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", number);

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	@Test
	@DisplayName("Should not register employee when matriculation is repeated and return status 400.")
	void registerEmployeeTest4() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		Agency agency1 = agencyRepository.save(agency);

		Address address = new Address("11111", "Nome1", 10, "Distrito1", "Cidade1", "Estado1");

		Employee employee = new Employee(null, "1111111111", LocalDate.now().withYear(1995), "55036580001", "Nome1",
				new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, address, agency1);

		employeeRepository.save(employee);

		EmployeeRequestDTO request = new EmployeeRequestDTO("1111111111", LocalDate.now().withYear(1995), "07772613083",
				"Nome2", new BigDecimal("1500.00"), "email2@gmail.com", "81922222222", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", agency1.getNumber());

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	@Test
	@DisplayName("Should not register employee when cpf is repeated and return status 400.")
	void registerEmployeeTest5() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		Agency agency1 = agencyRepository.save(agency);

		Address address = new Address("11111", "Nome1", 10, "Distrito1", "Cidade1", "Estado1");

		Employee employee = new Employee(null, "1111111111", LocalDate.now().withYear(1995), "55036580001", "Nome1",
				new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, address, agency1);

		employeeRepository.save(employee);

		EmployeeRequestDTO request = new EmployeeRequestDTO("2222222222", LocalDate.now().withYear(1995), "55036580001",
				"Nome2", new BigDecimal("1500.00"), "email2@gmail.com", "81922222222", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", agency1.getNumber());

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	@Test
	@DisplayName("Should not register employee when name is repeated and return status 400.")
	void registerEmployeeTest6() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		Agency agency1 = agencyRepository.save(agency);

		Address address = new Address("11111", "Nome1", 10, "Distrito1", "Cidade1", "Estado1");

		Employee employee = new Employee(null, "1111111111", LocalDate.now().withYear(1995), "55036580001", "Nome1",
				new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, address, agency1);

		employeeRepository.save(employee);

		EmployeeRequestDTO request = new EmployeeRequestDTO("2222222222", LocalDate.now().withYear(1995), "07772613083",
				"Nome1", new BigDecimal("1500.00"), "email2@gmail.com", "81922222222", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", agency1.getNumber());

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	@Test
	@DisplayName("Should not register employee when email is repeated and return status 400.")
	void registerEmployeeTest7() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		Agency agency1 = agencyRepository.save(agency);

		Address address = new Address("11111", "Nome1", 10, "Distrito1", "Cidade1", "Estado1");

		Employee employee = new Employee(null, "1111111111", LocalDate.now().withYear(1995), "55036580001", "Nome1",
				new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, address, agency1);

		employeeRepository.save(employee);

		EmployeeRequestDTO request = new EmployeeRequestDTO("2222222222", LocalDate.now().withYear(1995), "07772613083",
				"Nome2", new BigDecimal("1500.00"), "email1@gmail.com", "81922222222", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", agency1.getNumber());

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	@Test
	@DisplayName("Should not register employee when phone is repeated and return status 400.")
	void registerEmployeeTest8() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		Agency agency1 = agencyRepository.save(agency);

		Address address = new Address("11111", "Nome1", 10, "Distrito1", "Cidade1", "Estado1");

		Employee employee = new Employee(null, "1111111111", LocalDate.now().withYear(1995), "55036580001", "Nome1",
				new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, address, agency1);

		employeeRepository.save(employee);

		EmployeeRequestDTO request = new EmployeeRequestDTO("2222222222", LocalDate.now().withYear(1995), "07772613083",
				"Nome2", new BigDecimal("1500.00"), "email2@gmail.com", "81911111111", 40, EmployeeType.BANKING,
				EmployeeStatus.ACTIVE, "11111", "Nome1", 15, "Distrito1", "Cidade1", "Estado1", agency1.getNumber());

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/employees/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	// list employees

	@Test
	@DisplayName("Should list employees and return status 200.")
	void registerEmployeeTest9() throws Exception {
		List<Agency> agencies = List.of(new Agency(null, "11111", LocalDate.now(), null, null));

		Agency agency = agencyRepository.saveAll(agencies).get(0);

		List<Employee> employees = List.of(
				new Employee(null, "1111111111", LocalDate.now().withYear(1995), "55036580001", "Nome1",
						new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
						EmployeeStatus.ACTIVE, new Address("11111", "Nome1", 10, "Distrito1", "Cidade1", "Estado1"),
						agency),
				new Employee(null, "2222222222", LocalDate.now().withYear(1995), "76532695408", "Nome2",
						new BigDecimal("2500.00"), "email2@gmail.com", "81922222222", 40, EmployeeType.MANAGER,
						EmployeeStatus.ACTIVE, new Address("22222", "Nome2", 20, "Distrito2", "Cidade2", "Estado2"),
						agency));

		employeeRepository.saveAll(employees);

		mockMvc.perform(get("/employees/list")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	@DisplayName("Should list employees when employee status is inactive and return status 200.")
	void registerEmployeeTest10() throws Exception {
		List<Agency> agencies = List.of(new Agency(null, "11111", LocalDate.now(), null, null));

		Agency agency = agencyRepository.saveAll(agencies).get(0);

		List<Employee> employees = List.of(
				new Employee(null, "1111111111", LocalDate.now().withYear(1995), "55036580001", "Nome1",
						new BigDecimal("1500.00"), "email1@gmail.com", "81911111111", 40, EmployeeType.BANKING,
						EmployeeStatus.ACTIVE, new Address("11111", "Nome1", 10, "Distrito1", "Cidade1", "Estado1"),
						agency),
				new Employee(null, "2222222222", LocalDate.now().withYear(1995), "76532695408", "Nome2",
						new BigDecimal("2500.00"), "email2@gmail.com", "81922222222", 40, EmployeeType.MANAGER,
						EmployeeStatus.ACTIVE, new Address("22222", "Nome2", 20, "Distrito2", "Cidade2", "Estado2"),
						agency));

		employeeRepository.saveAll(employees);

		mockMvc.perform(get("/employees/list").queryParam("employeeStatus", "" + EmployeeStatus.INACTIVE))
				.andExpect(status().isOk()).andDo(print());
	}
}
