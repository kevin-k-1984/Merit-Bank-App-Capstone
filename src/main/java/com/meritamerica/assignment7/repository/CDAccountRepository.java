package com.meritamerica.assignment7.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment7.models.CDAccount;
import com.meritamerica.assignment7.models.AccountHolder;

public interface CDAccountRepository extends JpaRepository<CDAccount, Long>{

	public List<CDAccount> findByAccountHolder(AccountHolder accountHolder);
}
