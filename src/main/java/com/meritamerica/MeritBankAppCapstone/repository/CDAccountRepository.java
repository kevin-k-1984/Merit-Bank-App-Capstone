package com.meritamerica.MeritBankAppCapstone.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.MeritBankAppCapstone.models.CDAccount;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;

public interface CDAccountRepository extends JpaRepository<CDAccount, Long>{

	public List<CDAccount> findByAccountHolder(AccountHolder accountHolder);
}
