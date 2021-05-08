package com.meritamerica.assignment6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.models.CheckingAccount;
import com.meritamerica.assignment6.models.SavingsAccount;
import com.meritamerica.assignment6.services.CheckingAccountService;
import com.meritamerica.assignment6.services.SavingsAccountService;

@RestController
@RequestMapping("/SavingsAccounts")
public class SavingsAccountController {

	@Autowired
	private SavingsAccountService savingsAccountService;
	
	// ----- POSTs -----
	@PostMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addSavingsAccount(@PathVariable long id, @RequestBody SavingsAccount savingsAccount) {
		return this.savingsAccountService.addSavingsAccount(id, savingsAccount);
	}
	
	// ----- GETs ------
	@GetMapping
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccountService.getSavingsAccounts();
	}
	
	@GetMapping(value = "/{id}")
	public List<SavingsAccount> getSavingsAccountsForId(@PathVariable long id){
		return savingsAccountService.getSavingsAccountsForId(id);
	}
}
