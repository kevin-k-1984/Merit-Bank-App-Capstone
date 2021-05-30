package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.CDAccount;
import com.meritamerica.MeritBankAppCapstone.models.CDOffering;
import com.meritamerica.MeritBankAppCapstone.repository.CDAccountRepository;
import com.meritamerica.MeritBankAppCapstone.repository.CDOfferRepository;

@Service
public class CDAccountService {

	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private CDAccountRepository cdAccountRepository;
	@Autowired
	private CDOfferRepository cdOfferRepository;

	public AccountHolder addCDAccount(long account_id, long offer_id, CDAccount cdAccount) {
		CDOffering actual_offer = this.cdOfferRepository.findById(offer_id).orElse(null);
		actual_offer.getCDAccounts().add(cdAccount);
		
		cdAccount.setInterestRate(actual_offer.getInterestRate());
		cdAccount.setCdOffering(actual_offer);
		
		AccountHolder ah = this.accountHolderService.getAccountHolderById(account_id);
		ah.getCdAccounts().add(cdAccount);
		cdAccount.setAccountHolder(ah);
		
		return this.cdAccountRepository.save(cdAccount).getAccountHolder();
	}

	public AccountHolder addCDAccount(long account_id, CDAccount cdAccount) {
		AccountHolder ah = this.accountHolderService.getAccountHolderById(account_id);
		cdAccount.setAccountHolder(ah);
		ah.getCdAccounts().add(cdAccount);
		return this.cdAccountRepository.save(cdAccount).getAccountHolder();
	}
	
	public List<CDAccount> getCDAccounts() {
		return this.cdAccountRepository.findAll();
	}
	
	public List<CDAccount> getCDAccountsForId(long id){
		List<CDAccount> result = this.cdAccountRepository.findByAccountHolder(this.accountHolderService.getAccountHolderById(id));
		return result;
	}
}
