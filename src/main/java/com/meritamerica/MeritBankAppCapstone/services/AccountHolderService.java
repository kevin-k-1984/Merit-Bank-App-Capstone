package com.meritamerica.MeritBankAppCapstone.services;

import java.util.List;
import java.util.Optional;

import com.meritamerica.MeritBankAppCapstone.models.ContactDetails;
import com.meritamerica.MeritBankAppCapstone.models.User;
import com.meritamerica.MeritBankAppCapstone.repository.ContactDetailsRepository;
import com.meritamerica.MeritBankAppCapstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.repository.AccountHolderRepository;

@Service
public class AccountHolderService {

	@Autowired
	private AccountHolderRepository accountHolderRepository;
	@Autowired
	private ContactDetailsRepository contactDetailsRepository;
	@Autowired
	private UserRepository userRepository;

	public AccountHolderService() { }

	public AccountHolder addAccountHolder(AccountHolder accountHolder) throws UsernameNotFoundException {
		// extract data from account holder
//		ContactDetails details = accountHolder.getContact();
//		long UserId = accountHolder.getUser().getId();

		// remove references to unsaved data in account holder
//		accountHolder.setContact(null);
//		accountHolder.setUser(null);

		// save account holder
//		this.accountHolderRepository.save(accountHolder);

		// add  account holder reference to contact details and save contact details
//		details.setAccountHolder(accountHolder);
//		this.contactDetailsRepository.save(details);
//		accountHolder.setContact(details);

		// Get User and add to account holder
//		Optional<User> user = this.userRepository.findById(UserId);
//		user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
//		accountHolder.setUser(user.get());

		// add account holder to user and update user repo
//		user.get().setAccountHolder(accountHolder);
//		this.userRepository.save(user.get());

		return this.accountHolderRepository.save(accountHolder);
	}

	public List<AccountHolder> getAccountHolders() {		
		return this.accountHolderRepository.findAll();
	}

	public AccountHolder getAccountHolderById(long id) {
		return this.accountHolderRepository.findById(id).orElse(null);
	}
}