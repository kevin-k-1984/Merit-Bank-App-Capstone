package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.CheckingAccount;
import com.meritamerica.MeritBankAppCapstone.repository.CheckingRepository;

@Service
public class CheckingService {

	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private CheckingRepository checkingRepository;

	public List<CheckingAccount> getCheckingAccounts() {
		return this.checkingRepository.findAll();
	}

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		return this.checkingRepository.save(checkingAccount);
	}

	public List<CheckingAccount> getCheckingAccountsForId(long id) {
		List<CheckingAccount> result = this.checkingRepository.findByAccountHolder(this.accountHolderService.getAccountHolderById(id));
		return result;
	}
	
	
	
}
