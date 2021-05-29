package com.meritamerica.MeritBankAppCapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.MeritBankAppCapstone.models.AccountHolder;
import springfox.documentation.annotations.ApiIgnore;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
