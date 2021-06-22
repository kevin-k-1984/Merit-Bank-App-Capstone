package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.IRAAccount;
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
		CheckingAccount checkingAccount = new CheckingAccount(checkingAccountDTO.getBalance(), checkingAccountDTO.getIsDBA());

		user.getAccountHolder().getCheckingAccounts().add(checkingAccount);
		checkingAccount.setAccountHolder(user.getAccountHolder());

		this.checkingService.addCheckingAccount(checkingAccount);

		return user.getAccountHolder();
	}

	@PostMapping("/user/deleteCheckingAccount")
	@ResponseStatus(HttpStatus.OK)
	public AccountHolder deleteCheckingAccount(@RequestHeader("authorization") String auth, @RequestBody CheckingAccountDTO checkingAccountDTO) {
		this.checkingService.deleteCheckingAccount(checkingAccountDTO.getId());
		return this.jwtUtil.getUserFromToken(auth).getAccountHolder();
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
		private long id;
		private boolean isDBA;

		public CheckingAccountDTO() {
		}

		public CheckingAccountDTO(double balance, long id, boolean isDBA) {
			this.balance = balance;
			this.id = id;
			this.isDBA = isDBA;
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

		public boolean getIsDBA() {
			return this.isDBA;
		}

		public void setIsDBA(boolean isDBA) {
			this.isDBA = isDBA;
		}
	}
}
