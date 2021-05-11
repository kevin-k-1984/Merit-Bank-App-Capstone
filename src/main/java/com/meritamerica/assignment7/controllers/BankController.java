package com.meritamerica.assignment7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.services.BankService;

@RestController
public class BankController {
	
	@Autowired
	private BankService bankService;

	// ------ POSTs -------
	 @PostMapping("/AccountHolders")
	 @ResponseStatus(HttpStatus.CREATED)
	 public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
		return this.bankService.addAccountHolder(accountHolder);
	}
	
	// ----- GETs -----
	@GetMapping("/AccountHolders")
	public List<AccountHolder> getListOfAccountHolders() {
		return this.bankService.getAccountHolders();
	}
		
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable long id) {
		return this.bankService.getAccountHolderById(id);
	}

	@GetMapping("/Me")
	public void getCurrentAccountHolder(@RequestHeader("authorization") String auth) {

	}
}
