package com.meritamerica.assignment7.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.models.CDAccount;
import com.meritamerica.assignment7.models.CDOffering;
import com.meritamerica.assignment7.repository.CDAccountRepository;
import com.meritamerica.assignment7.repository.CDOfferRepository;

@Service
public class CDAccountService {

	@Autowired
	private BankService bankService;
	@Autowired
	private CDAccountRepository cdAccountRepository;
	@Autowired
	private CDOfferRepository cdOfferRepository;
	
	public AccountHolder addCDAccount(long account_id, long offer_id, CDAccount cdAccount) {
		CDOffering actual_offer = this.cdOfferRepository.findById(offer_id).orElse(null);
		actual_offer.getCDAccounts().add(cdAccount);
		
		cdAccount.setInterestRate(actual_offer.getInterestRate());
		cdAccount.setCdOffering(actual_offer);
		
		AccountHolder ah = this.bankService.getAccountHolderById(account_id);
		ah.getCdAccounts().add(cdAccount);
		cdAccount.setAccountHolder(ah);
		
		return this.cdAccountRepository.save(cdAccount).getAccountHolder();
	}

	public AccountHolder addCDAccount(long account_id, CDAccount cdAccount) {
		AccountHolder ah = this.bankService.getAccountHolderById(account_id);
		cdAccount.setAccountHolder(ah);
		ah.getCdAccounts().add(cdAccount);
		return this.cdAccountRepository.save(cdAccount).getAccountHolder();
	}
	
	public List<CDAccount> getCDAccounts() {
		return this.cdAccountRepository.findAll();
	}
	
	public List<CDAccount> getCDAccountsForId(long id){
		List<CDAccount> result = this.cdAccountRepository.findByAccountHolder(this.bankService.getAccountHolderById(id));
		return result;
	}
}
