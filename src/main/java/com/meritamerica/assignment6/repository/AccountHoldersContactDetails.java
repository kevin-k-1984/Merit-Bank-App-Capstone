package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.meritamerica.assignment6.models.AccountHolderContactDetails;

@RepositoryRestResource(path = "AccountHoldersContactDetails")
public interface AccountHoldersContactDetails extends JpaRepository<AccountHolderContactDetails, Integer> {

}
