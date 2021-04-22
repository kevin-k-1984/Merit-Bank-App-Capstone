package com.meritamerica.assignment6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.repository.AccountHolderRepository;

@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepository.save(accountHolder);
	}
	
	public List<AccountHolder> getAccountHolders() {
		return accountHolderRepository.findAll();
	}
	
	public AccountHolder getAccountById(long id) {
		return accountHolderRepository.findById(id).orElse(null);
	}
}
