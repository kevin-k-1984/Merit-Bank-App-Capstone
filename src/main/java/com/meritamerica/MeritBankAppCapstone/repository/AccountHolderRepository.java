package com.meritamerica.MeritBankAppCapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
