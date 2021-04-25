package com.meritamerica.assignment6.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment6.exceptions.ExceedsFraudSuspicionLimitException;
import com.meritamerica.assignment6.exceptions.MissingFieldException;
import com.meritamerica.assignment6.exceptions.NegativeAmountException;
import com.meritamerica.assignment6.exceptions.NotFoundException;
import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.models.CDAccount;
import com.meritamerica.assignment6.models.CDOffering;
import com.meritamerica.assignment6.models.CheckingAccount;
import com.meritamerica.assignment6.models.SavingsAccount;
import com.meritamerica.assignment6.repository.CheckingAccountRepository;
import com.meritamerica.assignment6.services.BankService;

@RestController
public class MeritController {
	
	@Autowired
	private BankService bankService;
	
	private Logger log = LoggerFactory.getLogger(MeritController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "Welcome to the Jungle...";
	}
	
	// ---- Accounts -----
	// -------------------
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {		
		return bankService.addAccountHolder(accountHolder);
	}
	
	@GetMapping(value = "/AccountHolders")
	public List<AccountHolder> getListOfAccountHolders() {
		return bankService.getAccountHolders();
	}
		
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable("id") long id) throws NotFoundException {
		return bankService.getAccountById(id);
	}
	
	// ---- CD Offers -----
	// --------------------
	@PostMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody CDOffering offering) {
		return bankService.addCDOffering(offering);
	}
	
	@GetMapping(value = "/CDOfferings")
	public List<CDOffering> getCDOfferings() {
		return bankService.getCDOfferings();
	}
	
	@GetMapping(value = "/CDOfferings/{id}")
	public CDOffering getCDOfferingById(@PathVariable("id") long id) throws NotFoundException {
		return bankService.getCDOfferingById(id);
	}
	
	// ---- Checking -----
	// -------------------
	@PostMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingToAccountHolder(@PathVariable("id") long id, @RequestBody CheckingAccount checkingAccount) {
		// TODO add way to allow bank service to add CheckingAccount
		return bankService.addCheckingAccount(checkingAccount);
	}
	
	// TODO need way to grab accounts from account holder by ID
	@GetMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	public List<CheckingAccount> getAccountHolderCheckingAccounts(@PathVariable("id") long id) throws NotFoundException {
		return bankService.getCheckingAccounts(id);
	}
	
	// ----- Savings ------
	// --------------------
	@PostMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsToAccountHolder(@PathVariable("id") long id, @RequestBody SavingsAccount savingsAccount) {
		return bankService.addSavingsAccount(savingsAccount);
	}
	
	@GetMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	public List<SavingsAccount> getAccountHolderSavingsAccounts(@PathVariable("id") long id) throws NotFoundException {
		return bankService.getSavingsAccounts();
	}
	
	// ------ CD Accounts ------
	// -------------------------
	@PostMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDToAccountHolder(@PathVariable("id") long id, @RequestBody CDAccount cdAccount) {
		return bankService.addCDAccount(cdAccount);
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CDAccounts")
	public List<CDAccount> getAccountHolderCDAccounts(@PathVariable("id") long id) throws NotFoundException {
		return bankService.getCDAccounts();
	}
	
}
