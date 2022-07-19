package com.example.WalletService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
public class WalletServiceGqlApplication {

	private static final String BASE_PACKAGE = "com.example.WalletService.Controller";
	public static void main(String[] args) {
		SpringApplication.run(WalletServiceGqlApplication.class, args);
	}




}