package com.org.apibancookay;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiBancoOkayApplication implements ApplicationRunner {
	public static void main(String[] args) {
		SpringApplication.run(ApiBancoOkayApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
	}
	//http://localhost:8080/v3/api-docs
	//http://localhost:8080/swagger-ui/index.html
}
