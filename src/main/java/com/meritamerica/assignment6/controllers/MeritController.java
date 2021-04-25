package com.meritamerica.assignment6.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.exceptions.NotFoundException;
import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.models.CDAccount;
import com.meritamerica.assignment6.models.CDOffering;
import com.meritamerica.assignment6.models.CheckingAccount;
import com.meritamerica.assignment6.models.SavingsAccount;

@RestController
public class MeritController {
	
//	@Autowired
//	private BankService bankService;

	List<CDOffering> cdOfferList = new ArrayList<CDOffering>();
	List<AccountHolder> accountHolderList = new ArrayList<AccountHolder>();

	private Logger log = LoggerFactory.getLogger(MeritController.class);
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	@Autowired
	private CDOfferRepository cdOfferRepository;
	@Autowired
	private CDAccountRepository cdAccountRepository;
	@Autowired
	private CheckingAccountRepository checkingAccountRepository;
	@Autowired
	private SavingsAccountRepository savingsAccountRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "Welcome to the Jungle...";
	}
	
	// ---- Accounts -----
	// -------------------
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
		if(accountHolder.getFirstName() == null ||
		accountHolder.getMiddleName() == null ||
		accountHolder.getLastName() == null ||
		accountHolder.getSSN() == null) {
			return null;
		}
		accountHolderList.add(accountHolder);
		return accountHolder;
	}
	
	@GetMapping(value = "/AccountHolders")
	public List<AccountHolder> getListOfAccountHolders() {
		return accountHolderList;
	}
		
	@GetMapping(value = "/AccountHolders/{id}")
	public Optional<AccountHolder> getAccountHolderById(@PathVariable long id) throws NotFoundException {
		return accountHolderRepository.findById(id);
	}

	// ---- CD Offers -----
	// --------------------
	@PostMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody CDOffering offering) {
		return cdOfferRepository.save(offering);
	}
	
	@GetMapping(value = "/CDOfferings")
	public List<CDOffering> getCDOfferings() {
		return cdOfferRepository.findAll();
	}
	
	@GetMapping(value = "/CDOfferings/{id}")
	public Optional<CDOffering> getCDOfferingById(@PathVariable long id) throws NotFoundException {
		return cdOfferRepository.findById(id);
	}
	
	// ---- Checking -----
	// -------------------
	@PostMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingToAccountHolder(@PathVariable long id, @RequestBody CheckingAccount checkingAccount) {
		return checkingAccountRepository.save(checkingAccount);
	}

	@GetMapping(value = "/CheckingAccounts")
	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccountRepository.findAll();
	}
	
	// TODO need way to grab accounts from account holder by ID
	@GetMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	public Optional<CheckingAccount> getAccountHolderCheckingAccounts(@PathVariable long id) throws NotFoundException {
		return checkingAccountRepository.findById(id);
	}
	
	// ----- Savings ------
	// --------------------
	@PostMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsToAccountHolder(@PathVariable long id, @RequestBody SavingsAccount savingsAccount) {
		return savingsAccountRepository.save(savingsAccount);
	}

	@GetMapping(value = "/SavingsAccounts")
	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccountRepository.findAll();
	}
	
	@GetMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	public Optional<SavingsAccount> getAccountHolderSavingsAccounts(@PathVariable long id) throws NotFoundException {
		return savingsAccountRepository.findById(id);
	}
	
	// ------ CD Accounts ------
	// -------------------------
	@PostMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDToAccountHolder(@PathVariable long id, @RequestBody CDAccount cdAccount) {
		return cdAccountRepository.save(cdAccount);
	}

	@GetMapping(value = "/CDAccounts")
	public List<CDAccount> getCDAccounts() {
		return cdAccountRepository.findAll();
	}

	@GetMapping(value = "/AccountHolder/{id}/CDAccounts")
	public Optional<CDAccount> getAccountHolderCDAccounts(@PathVariable long id) throws NotFoundException {
		return cdAccountRepository.findById(id);
	}
	
}
