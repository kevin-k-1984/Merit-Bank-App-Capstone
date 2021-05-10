package com.meritamerica.assignment7.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.repository.AccountHolderRepository;

@Service
public class BankService {

	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	// ---- Account Holder
	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepository.save(accountHolder);
	}

	public List<AccountHolder> getAccountHolders() {		
		return this.accountHolderRepository.findAll();
	}

	public AccountHolder getAccountHolderById(long id) {
		return this.accountHolderRepository.findById(id).orElse(null);
	}
}