package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.MeritBankAppCapstone.models.CDAccount;
import com.meritamerica.MeritBankAppCapstone.services.CDAccountService;

@RestController
public class CDAccountController {

	@Autowired
	private CDAccountService cdAccountService;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/AccountHolders/{account_id}/CDOffer/{offer_id}/CDAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCDAccount(@PathVariable long account_id, @PathVariable long offer_id, @RequestBody CDAccount cdAccount) {
		return this.cdAccountService.addCDAccount(account_id, offer_id, cdAccount);
	}

	@PostMapping(value = "/Me/CDAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCDAccount(@RequestHeader("authorization") String auth) {
		return this.cdAccountService.addCDAccount(
				this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getId(),
				new CDAccount()
		);
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

	@GetMapping("/Me/CDAccounts")
	public List<CDAccount> getCDAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.GetUserFromToken(auth).getAccountHolder().getCdAccounts();
	}
}
