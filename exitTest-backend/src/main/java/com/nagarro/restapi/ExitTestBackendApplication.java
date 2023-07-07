package com.nagarro.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class ExitTestBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExitTestBackendApplication.class, args);
	}

}
