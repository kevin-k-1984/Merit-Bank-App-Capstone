package com.meritamerica.assignment6.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment6.models.CDAccount;
import com.meritamerica.assignment6.models.AccountHolder;

public interface CDAccountRepository extends JpaRepository<CDAccount, Long>{

	public List<CDAccount> findByAccountHolder(AccountHolder accountHolder);
}
