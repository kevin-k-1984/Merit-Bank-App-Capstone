package com.meritamerica.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.meritamerica.assignment6.models.AccountHolder;

@RepositoryRestResource(collectionResourceRel = "AccountHolders", path = "AccountHolders")
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
	
//	@Override
//	@RestResource(exported = false)
//	public <S extends AccountHolder> S save(S entity);
}
