package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.MeritBankAppCapstone.models.CDAccount;
import com.meritamerica.MeritBankAppCapstone.services.CdService;

@RestController
public class CdController {

	@Autowired
	private CdService cdService;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/user/AccountHolders/{account_id}/CDOffer/{offer_id}/CDAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCDAccount(@PathVariable long account_id, @PathVariable long offer_id, @RequestBody CDAccount cdAccount) {
		return this.cdService.addCDAccount(account_id, offer_id, cdAccount);
	}

	@PostMapping(value = "/user/CDAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCDAccount(@RequestHeader("authorization") String auth) {
		return this.cdService.addCDAccount(
				this.jwtUtil.getUserFromToken(auth).getAccountHolder().getId(),
				new CDAccount()
		);
	}
	
	// ----- GETs -----
	@GetMapping("/user/AccountHolders/CDAccounts")
	public List<CDAccount> getCDAccounts(){
		return this.cdService.getCDAccounts();
	}
	
	@GetMapping(value = "/user/AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccountsForId(@PathVariable long id){
		return this.cdService.getCDAccountsForId(id);
	}

	@GetMapping("/user/CDAccounts")
	public List<CDAccount> getCDAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.getUserFromToken(auth).getAccountHolder().getCdAccounts();
	}
}
