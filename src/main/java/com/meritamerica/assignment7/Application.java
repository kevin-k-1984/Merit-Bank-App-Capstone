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
		user_admin.setUserName("admin");
		user_admin.setPassword("admin");
		user_admin.setActive(true);
		user_admin.setRoles("ROLE_ADMIN");

//		User user_user = new User();
//		user_user.setUserName("kevin");
//		user_user.setPassword("user");
//		user_user.setActive(true);
//		user_user.setRoles("ROLE_USER");
		
		repo.save(user_admin);
//		repo.save(user_user);
		
	}
}
