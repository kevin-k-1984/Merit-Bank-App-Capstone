package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.CheckingAccount;
import com.meritamerica.MeritBankAppCapstone.repository.CheckingRepository;

@Service
public class CheckingService {

	@Autowired
	private CheckingRepository checkingRepository;

	public List<CheckingAccount> getCheckingAccounts() {
		return this.checkingRepository.findAll();
	}

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		return this.checkingRepository.save(checkingAccount);
	}

	public void deleteCheckingAccount(long id) {
		this.checkingRepository.deleteById(id);
	}
}
