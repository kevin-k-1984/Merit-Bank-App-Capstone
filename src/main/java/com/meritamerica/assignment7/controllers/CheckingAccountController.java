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
import com.meritamerica.assignment6.services.CheckingAccountService;

@RestController
@RequestMapping("/CheckingAccounts")
public class CheckingAccountController {

	@Autowired
	private CheckingAccountService checkingAccountService;
	
	// ----- POSTs -----
	@PostMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCheckingAccount(@PathVariable long id, @RequestBody CheckingAccount checkingAccount) {
		return this.checkingAccountService.addCheckingAccount(id, checkingAccount);
	}
	
	// ----- GETs ------
	@GetMapping
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccountService.getCheckingAccounts();
	}
	
	@GetMapping(value = "/{id}")
	public List<CheckingAccount> getCheckingAccountsForId(@PathVariable long id){
		return checkingAccountService.getCheckingAccountsForId(id);
	}
}
