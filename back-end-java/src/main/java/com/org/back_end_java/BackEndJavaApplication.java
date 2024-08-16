package com.org.back_end_java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndJavaApplication implements CommandLineRunner {
	@Value("${info}")
	private String info;

	public static void main(String[] args) {
		SpringApplication.run(BackEndJavaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(info);
	}
}
