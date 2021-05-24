package com.meritamerica.assignment7.controllers;

import java.util.List;

import com.meritamerica.assignment7.Security.JwtUtil;
import com.meritamerica.assignment7.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.models.CheckingAccount;
import com.meritamerica.assignment7.services.CheckingAccountService;

@RestController
public class CheckingAccountController {

	@Autowired
	private CheckingAccountService checkingAccountService;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCheckingAccount(@PathVariable long id, @RequestBody CheckingAccount checkingAccount) {
		return this.checkingAccountService.addCheckingAccount(id, checkingAccount);
	}

	@PostMapping("/Me/CheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCheckingAccount(@RequestHeader("authorization") String auth){
		return this.checkingAccountService.addCheckingAccount(
				this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getId(),
				new CheckingAccount()
		);
	}
	
	// ----- GETs ------
	@GetMapping("/AccountHolders/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccountService.getCheckingAccounts();
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccountsForId(@PathVariable long id){
		return checkingAccountService.getCheckingAccountsForId(id);
	}

	@GetMapping("/Me/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getCheckingAccounts();
	}
}
