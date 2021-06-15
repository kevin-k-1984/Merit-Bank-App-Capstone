package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.CheckingAccount;
import com.meritamerica.MeritBankAppCapstone.services.CheckingService;

@RestController
public class CheckingController {

	@Autowired
	private CheckingService checkingService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/user/addCheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCheckingAccount(@RequestHeader("authorization") String auth, @RequestBody CheckingAccountDTO checkingAccountDTO) {

		User user = this.jwtUtil.getUserFromToken(auth);
		CheckingAccount checkingAccount = new CheckingAccount(checkingAccountDTO.getBalance());

		user.getAccountHolder().getCheckingAccounts().add(checkingAccount);
		checkingAccount.setAccountHolder(user.getAccountHolder());

		this.checkingService.addCheckingAccount(checkingAccount);

		return user.getAccountHolder();
	}
	
	// ----- GETs ------
	@GetMapping("/admin/checkingAccounts")
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingService.getCheckingAccounts();
	}

	@GetMapping("/user/checkingAccounts")
	public List<CheckingAccount> getCheckingAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.getUserFromToken(auth).getAccountHolder().getCheckingAccounts();
	}

	// ----- DTO -----
	public static class CheckingAccountDTO {

		private double balance;

		public CheckingAccountDTO() {
		}

		public CheckingAccountDTO(double balance) {
			this.balance = balance;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
	}
}
