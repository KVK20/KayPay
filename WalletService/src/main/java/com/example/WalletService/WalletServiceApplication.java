package com.example.WalletService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EntityScan(
//		basePackageClasses = {GWalletApplication.class, Jsr310JpaConverters.class}
//)
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableSwagger2
public class WalletServiceApplication {
	private static final String BASE_PACKAGE = "com.example.UserService.Controller";
	public static void main(String[] args) {

		SpringApplication.run(WalletServiceApplication.class, args);
	}



}