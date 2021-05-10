package com.meritamerica.assignment7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.models.CheckingAccount;
import com.meritamerica.assignment7.models.SavingsAccount;

//@RepositoryRestResource(path = "SavingsAccounts")
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long>{

	public List<SavingsAccount> findByAccountHolder(AccountHolder accountHolder);
}
