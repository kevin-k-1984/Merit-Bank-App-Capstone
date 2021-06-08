package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
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
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/user/AccountHolders/{id}/SavingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addSavingsAccount(@PathVariable long id, @RequestBody SavingsAccount savingsAccount) {
		return this.savingsService.addSavingsAccount(id, savingsAccount);
	}

	@PostMapping(value = "/user/SavingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addSavingsAccount(@RequestHeader("authorization") String auth) {
		return this.savingsService.addSavingsAccount(
				this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getId(),
				new SavingsAccount()
		);
	}
	
	// ----- GETs ------
	@GetMapping("/user/AccountHolders/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsService.getSavingsAccounts();
	}
	
	@GetMapping(value = "/user/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountsForId(@PathVariable long id){
		return savingsService.getSavingsAccountsForId(id);
	}

	@GetMapping("/user/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getSavingsAccounts();
	}
}
