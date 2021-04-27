package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment6.models.AccountHolder;

//@RepositoryRestResource(collectionResourceRel = "AccountHolders", path = "AccountHolders")
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
	//public List<AccountHolder> findAll();
}
