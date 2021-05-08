package com.meritamerica.assignment6.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.meritamerica.assignment6.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.exceptions.NotFoundException;
import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.models.CDAccount;
import com.meritamerica.assignment6.models.CheckingAccount;
import com.meritamerica.assignment6.models.SavingsAccount;
import com.meritamerica.assignment6.services.BankService;

@RestController
@RequestMapping("/AccountHolders")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
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
