package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.services.AccountHolderService;

@RestController
public class AccountHolderController {
	
	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;

	// ------ POSTs -------
	 @PostMapping("/AccountHolders")
	 @ResponseStatus(HttpStatus.CREATED)
	 public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
		return this.accountHolderService.addAccountHolder(accountHolder);
	}
	
	// ----- GETs -----
	@GetMapping("/AccountHolders")
	public List<AccountHolder> getListOfAccountHolders() {
		return this.accountHolderService.getAccountHolders();
	}
		
	@GetMapping("/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable long id) {
		return this.accountHolderService.getAccountHolderById(id);
	}

	@GetMapping("/Me")
	public AccountHolder getCurrentAccountHolder(@RequestHeader("authorization") String auth) {
	 	return this.jwtUtil.GetUserFromToken(auth).getAccountHolder();
	}
}
