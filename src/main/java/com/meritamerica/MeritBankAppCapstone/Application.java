package com.meritamerica.MeritBankAppCapstone;

import com.meritamerica.MeritBankAppCapstone.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.meritamerica.MeritBankAppCapstone.models.*;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		UserRepository repo = context.getBean(UserRepository.class);

		User user_admin = new User();
		user_admin.setUsername("admin");
		user_admin.setPassword("admin");
		user_admin.setActive(true);
		user_admin.setRole("ROLE_ADMIN");
		
		repo.save(user_admin);
		
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.meritamerica.MeritBankAppCapstone.controller"))
				.build()
				.apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Merit Bank API",
				"All avalible endpoints for communicating to Merit Bank Service",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Kevin Kemp", "http://MeritBank.com", "kkemp1984@gmail.com"),
				"API License",
				"http://MeritBank.com",
				Collections.emptyList());
	}
}
