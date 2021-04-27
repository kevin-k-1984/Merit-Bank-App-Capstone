package com.meritamerica.assignment6;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.meritamerica.assignment6.repository.AccountHolderRepository;
import com.meritamerica.assignment6.models.*;

//@EnableJpaRepositories(basePackages = "com.meritamerica.assignment6.repository")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		AccountHolderRepository repo = context.getBean(AccountHolderRepository.class);
		
		AccountHolder ah1 = new AccountHolder("Kevin", "J", "Kemp","123456789");
		
		CheckingAccount ch1 = new CheckingAccount(500);
		ch1.setAccountHolder(ah1);
		CheckingAccount ch2 = new CheckingAccount(1000);
		ch2.setAccountHolder(ah1);
		
		ah1.setCheckingAccounts(Arrays.asList(ch1, ch2));
		
		//repo.save(ah1);
		
	}
}
