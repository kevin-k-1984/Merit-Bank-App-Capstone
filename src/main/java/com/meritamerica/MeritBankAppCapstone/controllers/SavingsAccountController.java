package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.SavingsAccount;
import com.meritamerica.MeritBankAppCapstone.services.SavingsAccountService;

@RestController
public class SavingsAccountController {

	@Autowired
	private SavingsAccountService savingsAccountService;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addSavingsAccount(@PathVariable long id, @RequestBody SavingsAccount savingsAccount) {
		return this.savingsAccountService.addSavingsAccount(id, savingsAccount);
	}

	@PostMapping(value = "/Me/SavingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addSavingsAccount(@RequestHeader("authorization") String auth) {
		return this.savingsAccountService.addSavingsAccount(
				this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getId(),
				new SavingsAccount()
		);
	}
	
	// ----- GETs ------
	@GetMapping("/AccountHolders/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccountService.getSavingsAccounts();
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountsForId(@PathVariable long id){
		return savingsAccountService.getSavingsAccountsForId(id);
	}

	@GetMapping("/Me/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getSavingsAccounts();
	}
}
