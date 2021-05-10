package com.meritamerica.assignment7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.models.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long>{

	public List<CheckingAccount> findByAccountHolder(AccountHolder accountHolder);
}
