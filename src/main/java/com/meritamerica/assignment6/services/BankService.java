
package com.meritamerica.assignment6.services;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

//import com.meritamerica.assignment6.repository.AccountHolderRepository;
//import com.meritamerica.assignment6.repository.CDAccountRepository;
//import com.meritamerica.assignment6.repository.CDOfferRepository;
//import com.meritamerica.assignment6.repository.CheckingAccountRepository;
//import com.meritamerica.assignment6.repository.SavingsAccountRepository;

@RestController
public class BankService {

//	@Autowired
//	private AccountHolderRepository accountHolderRepository;
//	@Autowired
//	private CDOfferRepository cdOfferRepository;
//	@Autowired
//	private CDAccountRepository cdAccountRepository;
//	@Autowired
//	private CheckingAccountRepository checkingAccountRepository;
//	@Autowired
//	private SavingsAccountRepository savingsAccountRepository;

//	@PostMapping(value = "/AccountHolders")
//	@ResponseStatus(HttpStatus.CREATED)
//	public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
//		if(accountHolder.getFirstName() == null || accountHolder.getMiddleName() == null ||	accountHolder.getLastName() == null || accountHolder.getSSN() == null) {
//			return null;
//		}
//		accountHolder.setLastName("It Worked");
//		accountHolderRepository.save(accountHolder);
//		return accountHolder;
//	}
	
	// ---- Account Holder
//	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
//		System.out.println("Added Acct Holder to Repo");
//		return accountHolderRepository.save(accountHolder);
//	}

//	public List<AccountHolder> getAccountHolders() {
//		System.out.println("Retrieve list of Acct Holders");
//		return accountHolderRepository.findAll();
//	}

//	public AccountHolder getAccountById(Long id) {
//		System.out.println("Get acct by ID");
//		return getById(id);
//	}

//	public AccountHolder getById(Long id) {
//		return accountHolderRepository.findById(id).orElse(null);
//	}

	// ---- CD Offerings
//	public CDOffering addCDOffering(CDOffering offering) {
//		System.out.println("Added CD Offer to Repo");
//		return cdOfferRepository.save(offering);
//	}

//	public List<CDOffering> getCDOfferings() {
//		System.out.println("Retrieve list of CD offers");
//		return cdOfferRepository.findAll();
//	}

//	public CDOffering getCDOfferingById(Long id) {
//		System.out.println("Get cd offer by ID");
//		return cdOfferRepository.findById(id).orElse(null);
//	}

	// ---- CDAccount
//	public CDAccount addCDAccount(CDAccount cdAccount) {
//		System.out.println("Added Acct Holder to Repo");
//		return cdAccountRepository.save(cdAccount);
//	}

//	public List<CDAccount> getCDAccounts() {
//		System.out.println("Retrieve list of Acct Holders");
//		return cdAccountRepository.findAll();
//	}

//	public CDAccount getCDAccountById(Long id) {
//		System.out.println("Get cd acct by ID");
//		return cdAccountRepository.findById(id).orElse(null);
//	}

	// ---- Checking Account
//	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
//		System.out.println("Added Acct Holder to Repo");
//		return checkingAccountRepository.save(checkingAccount);
//	}

//	public List<CheckingAccount> getCheckingAccounts(@PathVariable Long id) {
//		System.out.println("Retrieve list of check accnts");
//		return getById(id).getCheckingAccounts();
//	}

//	public CheckingAccount getCheckingAccountById(Long id) {
//		System.out.println("Get cd acct by ID");
//		return checkingAccountRepository.findById(id).orElse(null);
//	}

//	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
//		System.out.println("Added Acct Holder to Repo");
//		return savingsAccountRepository.save(savingsAccount);
//	}

	// --- Savings Accounts
//	public List<SavingsAccount> getSavingsAccounts() {
//		System.out.println("Retrieve list of Acct Holders");
//		return savingsAccountRepository.findAll();
//	}

//	public SavingsAccount getSavingsgAccountById(Long id) {
//		System.out.println("Get cd acct by ID");
//		return savingsAccountRepository.findById(id).orElse(null);
//	}
}