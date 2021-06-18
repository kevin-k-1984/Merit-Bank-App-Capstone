package com.meritamerica.MeritBankAppCapstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.CheckingAccount;

public interface CheckingRepository extends JpaRepository<CheckingAccount, Long>{
	public List<CheckingAccount> findByAccountHolder(AccountHolder accountHolder);
}
