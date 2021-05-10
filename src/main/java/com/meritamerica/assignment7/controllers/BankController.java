package com.meritamerica.assignment7.controllers;

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

import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.services.BankService;

@RestController
@RequestMapping("/AccountHolders")
public class BankController {
	
	@Autowired
	private BankService bankService;

	@GetMapping("/")
	public String home(){
		return ("<h1>Welcome</h2>");
	}

	// ------ POSTs -------
	 @PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	 public List<AccountHolder> addAccountHolder(@RequestBody List<AccountHolder> accountHolder) {
		 for (AccountHolder ah : accountHolder) {
			this.bankService.addAccountHolder(ah);
		}
		 return this.bankService.getAccountHolders(); 
	}
	
	// ----- GETs -----
	@GetMapping
	public List<AccountHolder> getListOfAccountHolders() {
		return this.bankService.getAccountHolders();
	}
		
	@GetMapping(value = "/{id}")
	public AccountHolder getAccountHolderById(@PathVariable long id) {
		return this.bankService.getAccountHolderById(id);
	}
}
