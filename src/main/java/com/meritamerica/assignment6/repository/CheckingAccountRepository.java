package com.meritamerica.assignment6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.models.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long>{

	public List<CheckingAccount> findByAccountHolder(AccountHolder accountHolder);
}
