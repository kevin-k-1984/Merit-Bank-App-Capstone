package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.assignment6.models.SavingsAccount;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long>{

}
