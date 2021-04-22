package com.meritamerica.assignment6.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.services.AccountHolderService;

@RestController
public class Controller {
	
	// TODO add autowired class instances
	// add service
	@Autowired
	private AccountHolderService accountHolderService;
	
	// ---- Accounts -----
	// -------------------
	@PostMapping(value = "/AccountHolder")
	public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
		return accountHolderService.addAccountHolder(accountHolder); // add account holder(account holder)
	}
	
	
	
}
