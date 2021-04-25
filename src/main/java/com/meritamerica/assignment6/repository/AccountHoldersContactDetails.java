package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.assignment6.models.AccountHolderContactDetails;

@Repository
public interface AccountHoldersContactDetails extends JpaRepository<AccountHolderContactDetails, Long> {

}
