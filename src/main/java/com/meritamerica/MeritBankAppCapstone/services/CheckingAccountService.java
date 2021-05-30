package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.CheckingAccount;
import com.meritamerica.MeritBankAppCapstone.repository.CheckingAccountRepository;

@Service
public class CheckingAccountService {

	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private CheckingAccountRepository checkingAccountRepository;

	public List<CheckingAccount> getCheckingAccounts() {
		return this.checkingAccountRepository.findAll();
	}

	public AccountHolder addCheckingAccount(long id, CheckingAccount checkingAccount) {
		checkingAccount.setAccountHolder(this.accountHolderService.getAccountHolderById(id));
		checkingAccount.getAccountHolder().getCheckingAccounts().add(checkingAccount);
		return this.checkingAccountRepository.save(checkingAccount).getAccountHolder();
	}

	public List<CheckingAccount> getCheckingAccountsForId(long id) {
		List<CheckingAccount> result = this.checkingAccountRepository.findByAccountHolder(this.accountHolderService.getAccountHolderById(id));
		return result;
	}
	
	
	
}
