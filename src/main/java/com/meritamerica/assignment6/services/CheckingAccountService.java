package com.meritamerica.assignment6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.models.CheckingAccount;
import com.meritamerica.assignment6.repository.CheckingAccountRepository;

@Service
public class CheckingAccountService {

	@Autowired
	private BankService bankService;
	@Autowired
	private CheckingAccountRepository checkingAccountRepository;

	public List<CheckingAccount> getCheckingAccounts() {
		return this.checkingAccountRepository.findAll();
	}

	public AccountHolder addCheckingAccount(long id, CheckingAccount checkingAccount) {
		checkingAccount.setAccountHolder(this.bankService.getAccountHolderById(id));
		checkingAccount.getAccountHolder().getCheckingAccounts().add(checkingAccount);
		return this.checkingAccountRepository.save(checkingAccount).getAccountHolder();
	}

	public List<CheckingAccount> getCheckingAccountsForId(long id) {
		List<CheckingAccount> result = this.checkingAccountRepository.findByAccountHolder(this.bankService.getAccountHolderById(id));
		return result;
	}
	
	
	
}
