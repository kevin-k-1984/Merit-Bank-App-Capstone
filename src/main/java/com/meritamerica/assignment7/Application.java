package com.meritamerica.assignment7;

import com.meritamerica.assignment7.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.meritamerica.assignment7.models.*;

@SpringBootApplication
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
}
