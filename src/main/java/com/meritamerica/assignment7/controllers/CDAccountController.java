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
import com.meritamerica.assignment7.models.CDAccount;
import com.meritamerica.assignment7.services.CDAccountService;

@RestController
@RequestMapping("/CDAccounts")
public class CDAccountController {

	@Autowired
	private CDAccountService cdAccountService;
	
	// ----- POSTs -----
	@PostMapping(value = "/AccountHolders/{account_id}/CDOffer/{offer_id}/CDAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@PathVariable long account_id, @PathVariable long offer_id, @RequestBody CDAccount cdAccount) {
		return this.cdAccountService.addCDAccount(account_id, offer_id, cdAccount);
	}
	
	// ----- GETs -----
	@GetMapping("/AccountHolders/CDAccounts")
	public List<CDAccount> getCDAccounts(){
		return this.cdAccountService.getCDAccounts();
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccountsForId(@PathVariable long id){
		return this.cdAccountService.getCDAccountsForId(id);
	}
}
