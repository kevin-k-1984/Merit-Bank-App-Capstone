package com.meritamerica.MeritBankAppCapstone.controllers;

import java.util.List;

import com.meritamerica.MeritBankAppCapstone.Security.JwtUtil;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.CDOffering;
import com.meritamerica.MeritBankAppCapstone.models.User;
import com.meritamerica.MeritBankAppCapstone.services.CDOfferingsService;
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
	private CDOfferingsService cdOfferingsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	// ----- POSTs -----
	@PostMapping(value = "/user/addCdAccount/{offer_id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addCDAccount(@RequestHeader("authorization") String auth, @PathVariable long offer_id, @RequestBody CdAccountDTO cdAccountDTO) {

		User user = this.jwtUtil.getUserFromToken(auth);
		CDOffering offering = this.cdOfferingsService.getCDOfferingById(offer_id);
		CDAccount cdAccount = new CDAccount(cdAccountDTO.getBalance(), offering);

		offering.getCDAccounts().add(cdAccount);
		user.getAccountHolder().getCdAccounts().add(cdAccount);
		cdAccount.setAccountHolder(user.getAccountHolder());

		this.cdService.addCDAccount(cdAccount);

		return user.getAccountHolder();
	}

	@PostMapping(value = "/user/deleteCdAccount")
	@ResponseStatus(HttpStatus.OK)
	public AccountHolder deleteCdAccount(@RequestHeader("authorization") String auth, @RequestBody CdAccountDTO cdAccountDTO) {
		this.cdService.deleteCdAccount(cdAccountDTO.getId());
		return this.jwtUtil.getUserFromToken(auth).getAccountHolder();
	}
	
	// ----- GETs -----
	@GetMapping("/admin/cdAccounts")
	public List<CDAccount> getCDAccounts(){
		return this.cdService.getCDAccounts();
	}

	@GetMapping("/user/cdAccounts")
	public List<CDAccount> getCDAccountsForUser(@RequestHeader("authorization") String auth) {
		return this.jwtUtil.getUserFromToken(auth).getAccountHolder().getCdAccounts();
	}

	// ----- DTO -----
	public static class CdAccountDTO {

		private long id;
		private double balance;

		public CdAccountDTO() {}

		public CdAccountDTO(double balance) {
			this.balance = balance;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
	}
}
