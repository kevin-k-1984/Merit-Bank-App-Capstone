package com.meritamerica.MeritBankAppCapstone.repository;

import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import com.meritamerica.MeritBankAppCapstone.models.IRAAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRARepository extends JpaRepository<IRAAccount, Long> {
    public List<IRAAccount> findByAccountHolder(AccountHolder accountHolder);
}
