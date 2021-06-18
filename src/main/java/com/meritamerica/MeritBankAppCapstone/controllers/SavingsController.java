package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.CheckingAccount;
import com.meritamerica.MeritBankAppCapstone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.SavingsAccount;
import com.meritamerica.MeritBankAppCapstone.services.SavingsService;

@RestController
public class SavingsController {

	@Autowired
	private SavingsService savingsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/user/addSavingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addSavingsAccount(@RequestHeader("authorization") String auth, @RequestBody SavingsAccountDTO savingsAccountDTO) {

		User user = this.jwtUtil.getUserFromToken(auth);
		SavingsAccount savingsAccount = new SavingsAccount(savingsAccountDTO.getBalance());

		user.getAccountHolder().getSavingsAccounts().add(savingsAccount);
		savingsAccount.setAccountHolder(user.getAccountHolder());

		this.savingsService.addSavingsAccount(savingsAccount);

		return user.getAccountHolder();
	}

	@PostMapping("/user/deleteSavingsAccount")
	@ResponseStatus(HttpStatus.OK)
	public AccountHolder deleteCheckingAccount(@RequestHeader("authorization") String auth, @RequestBody SavingsAccountDTO savingsAccountDTO) {
		User user = this.jwtUtil.getUserFromToken(auth);
		this.savingsService.deleteSavingsAccount(savingsAccountDTO.getId());
		user.getAccountHolder().getSavingsAccounts().clear();
		return user.getAccountHolder();
	}
	
	// ----- GETs ------
	@GetMapping("/admin/savingsAccounts")
	public List<SavingsAccount> getSavingsAccounts(){
		return this.savingsService.getSavingsAccounts();
	}

	@GetMapping("/user/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.getUserFromToken(auth).getAccountHolder().getSavingsAccounts();
	}

	// ----- DTO -----
	public static class SavingsAccountDTO {

		private double balance;
		private long id;

		public SavingsAccountDTO() {
		}

		public SavingsAccountDTO(double balance, long id) {
			this.balance = balance;
			this.id = id;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
	}
}
