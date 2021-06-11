package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
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
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/user/AccountHolders/{id}/CheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCheckingAccount(@PathVariable long id, @RequestBody CheckingAccount checkingAccount) {
		return this.checkingService.addCheckingAccount(id, checkingAccount);
	}

	@PostMapping("/user/CheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCheckingAccount(@RequestHeader("authorization") String auth){
		return this.checkingService.addCheckingAccount(
				this.jwtUtil.getUserFromToken(auth).getAccountHolder().getId(),
				new CheckingAccount()
		);
	}
	
	// ----- GETs ------
	@GetMapping("/user/AccountHolders/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingService.getCheckingAccounts();
	}
	
	@GetMapping(value = "/user/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccountsForId(@PathVariable long id){
		return checkingService.getCheckingAccountsForId(id);
	}

	@GetMapping("/user/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.getUserFromToken(auth).getAccountHolder().getCheckingAccounts();
	}
}
