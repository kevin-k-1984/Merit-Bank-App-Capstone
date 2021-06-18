package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.CDAccount;
import com.meritamerica.MeritBankAppCapstone.models.CDOffering;
import com.meritamerica.MeritBankAppCapstone.repository.CdRepository;
import com.meritamerica.MeritBankAppCapstone.repository.CdOfferingRepository;

@Service
public class CdService {

	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private CdRepository cdRepository;
	@Autowired
	private CdOfferingRepository cdOfferingRepository;

	public AccountHolder addCDAccount(CDAccount cdAccount) {
		return this.cdRepository.save(cdAccount).getAccountHolder();
	}

//	public AccountHolder addCDAccount(long account_id, CDAccount cdAccount) {
//		AccountHolder ah = this.accountHolderService.getAccountHolderById(account_id);
//		cdAccount.setAccountHolder(ah);
//		ah.getCdAccounts().add(cdAccount);
//		return this.cdRepository.save(cdAccount).getAccountHolder();
//	}
	
	public List<CDAccount> getCDAccounts() {
		return this.cdRepository.findAll();
	}
	
	public List<CDAccount> getCDAccountsForId(long id){
		List<CDAccount> result = this.cdRepository.findByAccountHolder(this.accountHolderService.getAccountHolderById(id));
		return result;
	}
}
