package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.SavingsAccount;
import com.meritamerica.MeritBankAppCapstone.repository.SavingsAccountRepository;

@Service
public class SavingsAccountService {

	@Autowired
	private BankService bankService;
	@Autowired
	private SavingsAccountRepository savingsAccountRepository;

	public List<SavingsAccount> getSavingsAccounts() {
		return this.savingsAccountRepository.findAll();
	}

	public AccountHolder addSavingsAccount(long id, SavingsAccount savingsAccount) {
		savingsAccount.setAccountHolder(this.bankService.getAccountHolderById(id));
		savingsAccount.getAccountHolder().getSavingsAccounts().add(savingsAccount);
		return this.savingsAccountRepository.save(savingsAccount).getAccountHolder();
	}

	public List<SavingsAccount> getSavingsAccountsForId(long id) {
		List<SavingsAccount> result = this.savingsAccountRepository.findByAccountHolder(this.bankService.getAccountHolderById(id));
		return result;
	}
}
