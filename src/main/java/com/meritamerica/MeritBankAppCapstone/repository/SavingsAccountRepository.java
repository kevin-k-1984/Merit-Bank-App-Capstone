package com.meritamerica.MeritBankAppCapstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.SavingsAccount;

//@RepositoryRestResource(path = "SavingsAccounts")
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long>{

	public List<SavingsAccount> findByAccountHolder(AccountHolder accountHolder);
}
