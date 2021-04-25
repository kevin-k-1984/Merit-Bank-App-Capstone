package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.assignment6.models.AccountHolder;

import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>{
    //Optional<AccountHolder> findById(Long id);
}
