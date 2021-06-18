package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.SavingsAccount;
import com.meritamerica.MeritBankAppCapstone.repository.SavingsRepository;

@Service
public class SavingsService {

	@Autowired
	private SavingsRepository savingsRepository;

	public List<SavingsAccount> getSavingsAccounts() {
		return this.savingsRepository.findAll();
	}

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		return this.savingsRepository.save(savingsAccount);
	}

	public void deleteSavingsAccount(long id){
		this.savingsRepository.deleteById(id);
	}
}
